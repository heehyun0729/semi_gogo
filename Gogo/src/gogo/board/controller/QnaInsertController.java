package gogo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.board.dao.QnaDao;
import gogo.board.vo.QnaVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/qnaInsert")
public class QnaInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("spage", "/board/qnaInsert.jsp");
		
		String num = req.getParameter("qna_num");
		if(num != null && !num.equals("")) {
			QnaDao dao = QnaDao.getInstance();
			QnaVo vo = dao.detail(Integer.parseInt(num));
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dir = getServletContext().getRealPath("/upload/qna");
		System.out.println(dir);
		MultipartRequest mr = new MultipartRequest(
					req,
					dir,
					1024 * 1024 * 5,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
		
		QnaDao dao = QnaDao.getInstance();
		int qna_num = dao.getMaxNum() + 1;	// 문의 글번호 받아오기
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String cate = mr.getParameter("cate");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String pwd = mr.getParameter("pwd");
		int menu_num = Integer.parseInt(mr.getParameter("menu_num"));
		
		// 이미지 테이블에 이미지 추가
		ImageDao dao1 = ImageDao.getInstance();
		for(int i = 1 ; i <= 3 ; i++) {
			String orgFileName = mr.getOriginalFileName("file" + i);
			if(orgFileName != null && !orgFileName.equals("")) {
				String saveFileName = mr.getFilesystemName("file" + i);
				ImageVo vo = new ImageVo(0, 0, orgFileName, saveFileName, menu_num, qna_num);
				int n = dao1.insert(vo);
				if(n <= 0) {
					// 오류 처리
					System.out.println("이미지삽입오류");
				}
			}
		}
		// 문의 테이블에 글 추가
		int num = 0;
		int ref = 0;
		int lev = 0;
		int step = 0;
		
		String snum = mr.getParameter("qna_num");
		if(snum != null && !snum.equals("")) {	// 답글인 경우
			num = Integer.parseInt(mr.getParameter("qna_num"));
			ref = Integer.parseInt(mr.getParameter("qna_ref"));
			lev = Integer.parseInt(mr.getParameter("qna_level"));
			step = Integer.parseInt(mr.getParameter("qna_step"));
		}
		QnaVo vo = new QnaVo(num, mem_id, cate, title, content, pwd, null, ref, lev, step);
		int n1 = dao.insert(vo);
		if(n1 > 0) {
			resp.sendRedirect(req.getContextPath() + "/board/qna?menu_num=" + menu_num);
		}else {
			// 오류처리
			System.out.println("QnA삽입오류");
		}
	}
}
