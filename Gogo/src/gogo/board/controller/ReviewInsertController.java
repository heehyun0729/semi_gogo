package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewVo;
import gogo.order.dao.DetailBuyDao;
import gogo.order.vo.ReviewProdListVo;

@WebServlet("/board/reviewInsert")
public class ReviewInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		DetailBuyDao dao = DetailBuyDao.getInstance();
		ArrayList<ReviewProdListVo> list = dao.reviewProdList(mem_id);

		req.setAttribute("list", list);
		req.setAttribute("spage", "/board/reviewInsert.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		int detailBuy_num = Integer.parseInt(req.getParameter("prod"));
		String review_title = req.getParameter("title");
		String review_content = req.getParameter("content");
		int review_star = Integer.parseInt(req.getParameter("star"));
		
		ReviewVo vo = new ReviewVo(0, mem_id, detailBuy_num, review_title, review_content, review_star, null, 0);
		ReviewDao dao = ReviewDao.getInstance();
		int n = dao.insert(vo);
		if(n > 0) {
			resp.sendRedirect(req.getContextPath() + "/home.jsp/board/review");
		}else {
			// 오류 처리
			System.out.println("review DB 추가 실패");
		}
	}
}
