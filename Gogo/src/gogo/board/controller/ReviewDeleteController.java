package gogo.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.QnaDao;
import gogo.board.dao.ReviewDao;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/reviewDelete")
public class ReviewDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("menu_num", menu_num);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
		if(id.equals("admin")) {
			
		}else {
			String qna_num = req.getParameter("review_num");
			req.setAttribute("review_num", qna_num);
			req.setAttribute("spage", "/board/reviewDelete.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		
		ImageDao idao = ImageDao.getInstance();
		ReviewDao rdao = ReviewDao.getInstance();
		
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		// 저장된 이미지 삭제
		ArrayList<ImageVo> list = idao.list(menu_num, review_num);
		if(list != null) {
			for(ImageVo vo : list) {
				File f = new File(getServletContext().getRealPath("/upload/qna/" + vo.getImg_saveImg()));
				if(!f.delete()) {
					// 오류 처리
					System.out.println("저장된 이미지 삭제 실패");
				}
			}
		}
		// image 테이블 DB 삭제
		int n = idao.delete(menu_num, review_num);
		if(n <= 0) {
			// 오류 처리
			System.out.println("image DB 삭제 실패");
		}
		// review 테이블 DB 삭제
		int n1 = rdao.delete(review_num);
		if(n1 <= 0) {
			// 오류 처리
			System.out.println("qna DB 삭제 실패");
		}else {
			resp.sendRedirect(req.getContextPath() + "/board/review?menu_num=" + menu_num);
		}
	}
}
