package gogo.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BasketDao;
import gogo.order.dao.BuyDao;
import gogo.order.dao.PayDao;
import gogo.order.vo.BuyVo;
import gogo.order.vo.PayVo;

@WebServlet("/order/payInsert")
public class PayInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("mem_id");		
		String addr = req.getParameter("addr");
		int buy_num = Integer.parseInt(req.getParameter("buy_num"));
		
		boolean ok = true;

		// 장바구니 비우기
		BasketDao dao = BasketDao.getInstance();
		int nn = dao.deleteAll(id);
		if(nn <= 0) {
			// 오류처리
			ok = false;
			System.out.println("장바구니 비우기 실패");
		}
		
		// buy 테이블 배송주소 수정
		BuyVo bvo = new BuyVo(buy_num, null, addr, null);
		BuyDao bdao = BuyDao.getInstance();
		int n = bdao.update(bvo);
		if(n <= 0) {
			// 오류처리
			ok = false;
			System.out.println("buy DB 수정 실패");
		}
		
		// pay 테이블에 DB 추가
		String pay_how = req.getParameter("payhow");
		int pay_sum = Integer.parseInt(req.getParameter("pay_sum"));
		PayVo pvo = new PayVo(0, buy_num, pay_how, pay_sum, null, 0);
		PayDao pdao = PayDao.getInstance();
		int n1 = pdao.insert(pvo);
		if(n1 <= 0) {
			// 오류처리
			ok = false;
			System.out.println("pay DB 추가 실패");
		}
		
		if(ok) {
			req.setAttribute("spage", "/order/payOk.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
