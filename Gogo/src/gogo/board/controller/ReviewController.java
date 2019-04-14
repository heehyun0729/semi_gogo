package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewListVo;

@WebServlet("/board/review")
public class ReviewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReviewDao dao = ReviewDao.getInstance();
		ArrayList<ReviewListVo> list = dao.list();
		
		req.setAttribute("list", list);
		req.setAttribute("spage", "/board/reviewList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
