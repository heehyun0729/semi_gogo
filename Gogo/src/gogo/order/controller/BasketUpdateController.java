package gogo.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BasketDao;

@WebServlet("/order/basketUpdate.do")
public class BasketUpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int basket_num = Integer.parseInt(req.getParameter("basket_num"));
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		BasketDao dao = BasketDao.getInstance();
		int n = dao.update(basket_num, cnt);
		if(n > 0) {
			resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
		}else {
			// 오류처리
			System.out.println("장바구니 수량 수정 실패");
		}
	}
}
