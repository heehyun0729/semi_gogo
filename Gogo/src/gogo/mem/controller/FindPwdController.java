package gogo.mem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
@WebServlet("/mem/findPwd.do")
public class FindPwdController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("spage", "/mem/findPwd.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_name=req.getParameter("mem_name");
		String mem_email=req.getParameter("mem_email");
		MemDao dao=MemDao.getInstance();
		String result=dao.findId(mem_name, mem_email);
		if(result==null) {
			req.setAttribute("msg", "회원정보가 확인되지 않습니다. 올바른 정보를 입력해주세요.");
			req.setAttribute("spage", "/mem/findPwd.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/mem/jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
