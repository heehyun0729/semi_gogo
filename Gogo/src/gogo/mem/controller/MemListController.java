package gogo.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
import gogo.mem.vo.MemVo;
//////////////[관리자페이지] 회원리스트 불러오기
@WebServlet("/admin/mem/memList")
public class MemListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=getInitParameter("pageNum");//페이지번호 받아오기
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int endRow=pageNum*8;//끝페이지
		int startRow=endRow-7;//시작페이지
		MemDao dao=MemDao.getInstance();
		ArrayList<MemVo> list=dao.list(startRow, endRow);
		
		int pageCount=(int)Math.ceil(dao.getCount()/8.0);
		int startPageNum=((pageNum-1)/8*8)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("spage", "/admin/mem/memList.jsp");
		req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		
	}
}
