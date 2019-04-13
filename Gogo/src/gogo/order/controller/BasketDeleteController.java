package gogo.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BasketDao;

@WebServlet("/order/basketDelete.do")
public class BasketDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String select = req.getParameter("select");
		
		BasketDao dao = BasketDao.getInstance();
		if(select.equals("ck")) {	// ������ �����͸� üũ�ڽ��� ������ ���
			String[] nums = req.getParameterValues("check");
			if(nums != null) {
				for(String num : nums) {
					int basket_num = Integer.parseInt(num);
					int n = dao.delete(basket_num);
					if(n <= 0 ) {
						// ����ó��
						System.out.println("��ٱ��� ��ǰ ���� ����1");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
		}else if(select.equals("all")) {	// ��ٱ��� ���⸦ ������ ���
			int n = dao.deleteAll(mem_id);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
			}else {
				// ����ó��
				System.out.println("��ٱ��� ���� ����");
			}
		}else if(select.equals("one")) {	// ������ �����͸� ���� ������ ���
			int basket_num = Integer.parseInt(req.getParameter("basket_num"));
			int n = dao.delete(basket_num);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/basketList.do");
			}else {
				// ����ó��
				System.out.println("��ٱ��� ��ǰ ���� ����2");
			}
		}
	}
}
