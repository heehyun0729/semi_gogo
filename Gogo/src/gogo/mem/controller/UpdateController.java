package gogo.mem.controller;
/////
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
import gogo.mem.vo.MemVo;
@WebServlet("/mypage/myInfo.do")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id=(String)req.getSession().getAttribute("mem_id");
		
		MemDao dao=MemDao.getInstance();
		MemVo vo=dao.getinfo(mem_id);
		//req.setAttribute("mem_id", mem_id);
		req.setAttribute("vo", vo);
		String mem_bday=vo.getMem_bday();
		String year=mem_bday.split("/")[0];
		String month=mem_bday.split("/")[1];
		String day=mem_bday.split("/")[2];
		System.out.println(year+month+day);
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
		String year=req.getParameter("year");
		String month=req.getParameter("month");
		String day=req.getParameter("day");
		String mem_bday=null;
		if(year != null  && !year.equals("")) {
			mem_bday = year +  "/" + month + "/" + day;
		}
		MemVo vo=new MemVo(mem_id,mem_pwd, mem_name, mem_phone, mem_email, mem_addr, mem_bday,0);
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
