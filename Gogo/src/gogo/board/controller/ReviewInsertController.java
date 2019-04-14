package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}
}
