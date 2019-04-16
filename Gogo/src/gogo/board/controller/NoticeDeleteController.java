package gogo.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.NoticeDao;
import gogo.board.dao.QnaDao;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
@WebServlet("/board/noticeDelete.do")
public class NoticeDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		String notice_num = req.getParameter("notice_num");
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("notice_num", notice_num);
		req.setAttribute("spage", "/admin/board/noticeDelete.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		// 저장된 이미지 삭제
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> list = idao.list(menu_num, notice_num);
		if(list != null) {
			for(ImageVo vo : list) {
				File f = new File(getServletContext().getRealPath("/upload/notice/" + vo.getImg_saveImg()));
				if(!f.delete()) {
					// 오류 처리
					System.out.println("저장된 이미지 삭제 실패");
				}
			}
		}
		// image 테이블 DB 삭제
		int n = idao.delete(menu_num, notice_num);
		if(n <= 0) {
			// 오류 처리
			System.out.println("image DB 삭제 실패");
		}
		// notice 테이블 DB 삭제
		NoticeDao ndao = NoticeDao.getInstance();
		int n1 = ndao.delete(notice_num);
		if(n1 <= 0) {
			// 오류 처리
			System.out.println("notice DB 삭제 실패");
		}else {
			resp.sendRedirect(req.getContextPath() + "/board/noticeList.do?menu_num=" + menu_num);
		}
	}
	
}
