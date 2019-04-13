package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.NoticeDao;
import gogo.board.vo.NoticeVo;
@WebServlet("/board/noticeList.do")
public class NoticeListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		
		//검색조건
		String cate=req.getParameter("cate");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int endRow=pageNum*10;
		int startRow=endRow-9;
		NoticeDao dao=NoticeDao.getInstance();
		ArrayList<NoticeVo> list=dao.list(startRow,endRow,cate,field,keyword);
		
		int pageCount=(int)Math.ceil(dao.getCount(field,keyword)/10.0);
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPageNum);
		req.setAttribute("endPage", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("cate", cate);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/board/noticeList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/board/noticeList.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/board/noticeList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
