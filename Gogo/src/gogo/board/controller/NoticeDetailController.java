package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.NoticeDao;
import gogo.board.dao.QnaDao;
import gogo.board.vo.NoticeVo;
import gogo.board.vo.QnaVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
@WebServlet("/board/noticeDetail.do")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVo nvo = ndao.detail(notice_num);
		
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> ilist = idao.list(9, notice_num);
		 
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("nvo", nvo);
		req.setAttribute("ilist", ilist);
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/board/noticeDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")){	
			req.setAttribute("spage", "/admin/board/noticeDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/board/noticeDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}	
	}
}
