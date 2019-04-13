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

		// ��ٱ��� ����
		BasketDao dao = BasketDao.getInstance();
		int nn = dao.deleteAll(id);
		if(nn <= 0) {
			// ����ó��
			ok = false;
			System.out.println("��ٱ��� ���� ����");
		}
		
		// buy ���̺� ����ּ� ����
		BuyVo bvo = new BuyVo(buy_num, null, addr, null);
		BuyDao bdao = BuyDao.getInstance();
		int n = bdao.update(bvo);
		if(n <= 0) {
			// ����ó��
			ok = false;
			System.out.println("buy DB ���� ����");
		}
		
		// pay ���̺� DB �߰�
		String pay_how = req.getParameter("payhow");
		int pay_sum = Integer.parseInt(req.getParameter("pay_sum"));
		PayVo pvo = new PayVo(0, buy_num, pay_how, pay_sum, null, 0);
		PayDao pdao = PayDao.getInstance();
		int n1 = pdao.insert(pvo);
		if(n1 <= 0) {
			// ����ó��
			ok = false;
			System.out.println("pay DB �߰� ����");
		}
		
		if(ok) {
			req.setAttribute("spage", "/order/payOk.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
