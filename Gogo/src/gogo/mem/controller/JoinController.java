package gogo.mem.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
import gogo.mem.vo.MemVo;
@WebServlet("/mem/join")
// test
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("spage", "/mem/join.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//int mem_num=Integer.parseInt(req.getParameter("mem_num"));
		String mem_id=req.getParameter("mem_id");
		String mem_pwd=req.getParameter("mem_pwd");
		String mem_name=req.getParameter("mem_name");
		String mem_phone=req.getParameter("mem_phone");
		String phonetext=req.getParameter("phonetext");
		mem_phone += phonetext;
		String mem_email=req.getParameter("mem_email");
		String mem_addr=req.getParameter("mem_addr");
		MemVo vo = new MemVo(mem_id, mem_pwd, mem_name, mem_phone, mem_email, mem_addr, 0);
		MemDao dao = new MemDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("spage", "/mem/login");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			// 오류처리
			System.out.println("회원가입 실패");
		}			
	}
}
