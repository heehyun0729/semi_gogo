package gogo.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewListVo;
import gogo.board.vo.ReviewVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/reviewUpdate")
public class ReviewUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		int review_num = Integer.parseInt(req.getParameter("review_num"));
	
		ReviewDao dao = ReviewDao.getInstance();
		ReviewListVo vo = dao.detail(review_num);
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("review_num", review_num);
		req.setAttribute("vo", vo);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/board/reviewUpdate.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/board/reviewUpdate.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 새로운 파일 업로드
		String dir = getServletContext().getRealPath("/upload/review");
		MultipartRequest mr = new MultipartRequest(
				req,
				dir,
				1024 * 1024 * 5,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
		
		String review_title = mr.getParameter("title");
		String review_content = mr.getParameter("content");
		int review_star = Integer.parseInt(mr.getParameter("star"));
		int review_num = Integer.parseInt(mr.getParameter("review_num"));
		int menu_num = Integer.parseInt(mr.getParameter("menu_num"));
		
		// 기존 파일 삭제
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> list = idao.list(menu_num, review_num);
		if(list != null) {
			for(ImageVo vo : list) {
				File f = new File(getServletContext().getRealPath("/upload/review/" + vo.getImg_saveImg()));
				if(!f.delete()) {
					// 오류 처리
					System.out.println("저장된 이미지 삭제 실패");
				}
			}
			// 이미지 테이블 DB 삭제
			int n = idao.delete(menu_num, review_num);
			if(n <= 0) {
				// 오류 처리
				System.out.println("image DB 삭제 실패");
			}
		}
		
		// 이미지 테이블에 DB 추가
		for(int i = 1 ; i <= 3 ; i++) {
			String orgFileName = mr.getOriginalFileName("file" + i);
			if(orgFileName != null && !orgFileName.equals("")) {
				String saveFileName = mr.getFilesystemName("file" + i);
				ImageVo vo = new ImageVo(0, 0, orgFileName, saveFileName, menu_num, review_num);
				int n1 = idao.insert(vo);
				if(n1 <= 0) {
					// 오류 처리
					System.out.println("이미지 DB 삽입 오류");
				}
			}
		}
		
		// review DB 수정
		ReviewDao rdao = ReviewDao.getInstance();
		ReviewVo rvo = new ReviewVo(review_num, null, 0, review_title, review_content, review_star, null, 0);
		int n2 = rdao.update(rvo);
		if(n2 <= 0) {
			// 오류 처리
			System.out.println("review DB 수정 오류");
		}else {
			resp.sendRedirect(req.getContextPath() + "/board/review?menu_num=" + menu_num + "&review_num=" + review_num);
		}
	}
}
