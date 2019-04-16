package gogo.mem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gogo.mem.dao.MemDao;
@WebServlet("/mem/delete.do")
public class MemDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		String mem_id=(String)req.getSession().getAttribute("mem_id");
		String mem_pwd=req.getParameter("mem_pwd");
		MemDao dao=MemDao.getInstance();
		boolean result=dao.delete(mem_id, mem_pwd);
		if(result){
			session.invalidate();
			resp.sendRedirect(req.getContextPath() +"/home");
		}else {
			req.setAttribute("spage", "/mem/memDelete.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
