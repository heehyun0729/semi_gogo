package gogo.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mem.dao.MemDao;
import gogo.mem.vo.MemVo;
import gogo.order.dao.BuyDao;
import gogo.order.vo.BuyListVo;

@WebServlet("/order/buy")
public class BuyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		BuyDao dao = BuyDao.getInstance();
		ArrayList<BuyListVo> list = dao.list(mem_id);
		int buy_num = list.get(0).getBuy_num();
		
		MemDao mdao = MemDao.getInstance();
		MemVo mvo = mdao.getinfo(mem_id);
		
		req.setAttribute("list", list);
		req.setAttribute("buy_num", buy_num);
		req.setAttribute("mvo", mvo);
		req.setAttribute("spage", "/order/orderForm.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
