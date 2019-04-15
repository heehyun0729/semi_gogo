package gogo.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewListVo;
import gogo.board.vo.ReviewVo;

@WebServlet("/mypage/myreview")
public class MyReviewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");

		String spageNum = req.getParameter("pageNum");
		String keyword = req.getParameter("keyword");
		
		int pageNum = 1; 
		if(spageNum != null && !spageNum.equals("")) {
				pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;
		
		ReviewDao dao = ReviewDao.getInstance();
		ArrayList<ReviewListVo> list = dao.list(mem_id, startRow, endRow, keyword);
		
		int pageCnt = (int)Math.ceil(dao.getCnt(keyword) / 10.0);
		int startPage = ((pageNum - 1) / 10) * 10 + 1;
		int endPage = startPage + 9;
		if(pageCnt < endPage) {
			endPage = pageCnt;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("menu_num", 11);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startRow", startRow);
		req.setAttribute("endRow", endRow);
		req.setAttribute("pageCnt", pageCnt);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("keyword", keyword);
		
		req.setAttribute("spage", "/mypage/myreviewList.jsp?menu_num=11");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
