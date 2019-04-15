package gogo.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
import gogo.mem.vo.MemVo;
@WebServlet("/admin/memsUpdate.do")
public class MemsUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String mem_id=(String)req.getSession().getAttribute("mem_id");
		String mem_id=req.getParameter("mem_id");
		MemDao dao=MemDao.getInstance();
		MemVo vo=dao.getinfo(mem_id);
		//req.setAttribute("mem_id", mem_id);
		req.setAttribute("vo", vo);
		req.setAttribute("spage", "/mem/memUpdate.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
		
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id=req.getParameter("mem_id");
		String mem_pwd=req.getParameter("mem_pwd");
		String mem_name=req.getParameter("mem_name");
		String mem_phone=req.getParameter("mem_phone");
		String phonetext=req.getParameter("phonetext");
		mem_phone += phonetext;
		String mem_email=req.getParameter("mem_email");
		String mem_addr=req.getParameter("mem_addr");
		MemVo vo=new MemVo(mem_id,mem_pwd, mem_name, mem_phone, mem_email, mem_addr,0);
		MemDao dao=new MemDao();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("spage","/mem/memUpdate" );
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			System.out.println("회원정보 수정 실패");
		}
	}
}
