package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.QnaDao;
import gogo.board.vo.QnaVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/qnaDetail")
public class QnaDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			doPost(req, resp);
		}else {
			String menu_num = req.getParameter("menu_num");
			String qna_num = req.getParameter("qna_num");
			req.setAttribute("menu_num", menu_num);
			req.setAttribute("qna_num", qna_num);
			req.setAttribute("spage", "/board/pwdCheck.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qna_num = Integer.parseInt(req.getParameter("qna_num"));
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("qna_num", qna_num);
		req.setAttribute("menu_num", menu_num);

		QnaDao qdao = QnaDao.getInstance();
		QnaVo qvo = qdao.detail(qna_num);
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> ilist = idao.list(10, qna_num);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")){	
			req.setAttribute("qvo", qvo);
			req.setAttribute("ilist", ilist);
			req.setAttribute("spage", "/board/qnaDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			String pwd = req.getParameter("pwd");
			if(pwd.equals(qvo.getQna_pwd())) {
				req.setAttribute("qvo", qvo);
				req.setAttribute("ilist", ilist);
				req.setAttribute("spage", "/board/qnaDetail.jsp");
				req.getRequestDispatcher("/home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
				req.setAttribute("spage", "/board/pwdCheck.jsp");
				req.getRequestDispatcher("/home.jsp").forward(req, resp);
			}
		}
	}
}
