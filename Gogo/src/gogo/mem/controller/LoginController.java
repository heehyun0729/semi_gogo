package gogo.mem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gogo.mem.dao.MemDao;
@WebServlet("/mem/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("spage", "/mem/login.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id=req.getParameter("mem_id");
		String mem_pwd=req.getParameter("mem_pwd");
		MemDao dao=MemDao.getInstance(); 
		boolean result=dao.isMem(mem_id, mem_pwd);
		int blockNum=dao.blockMem(mem_id, mem_pwd);
		if(result) {
			HttpSession session=req.getSession();
			session.setAttribute("mem_id", mem_id);
			req.setAttribute("spage", "/main.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(blockNum>0) {
			req.setAttribute("errMsg", "ȸ�������� ���� �����Դϴ�");
		}else {
			req.setAttribute("errMsg","���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			req.setAttribute("spage", "/mem/login.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
