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
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/reviewDetail")
public class ReviewDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int review_num = Integer.parseInt(req.getParameter("review_num"));
		
		ReviewDao dao = ReviewDao.getInstance();
		ReviewListVo vo = dao.detail(review_num);
		
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> ilist = idao.list(11, review_num);
		
		req.setAttribute("vo", vo);
		req.setAttribute("ilist", ilist);
		req.setAttribute("spage", "/board/reviewDetail.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
