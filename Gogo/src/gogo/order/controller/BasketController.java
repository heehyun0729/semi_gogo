package gogo.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BasketDao;
import gogo.order.vo.BasketListVo;
import gogo.order.vo.BasketVo;

@WebServlet("/order/basketList.do")
public class BasketController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		BasketDao dao = BasketDao.getInstance();
		ArrayList<BasketListVo> list = dao.list(mem_id);
		
		req.setAttribute("list", list);
		req.setAttribute("spage", "/order/basketList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
