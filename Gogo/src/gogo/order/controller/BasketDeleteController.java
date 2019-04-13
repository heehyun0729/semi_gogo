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
		if(select.equals("ck")) {	// 삭제할 데이터를 체크박스로 선택한 경우
			String[] nums = req.getParameterValues("check");
			if(nums != null) {
				for(String num : nums) {
					int basket_num = Integer.parseInt(num);
					int n = dao.delete(basket_num);
					if(n <= 0 ) {
						// 오류처리
						System.out.println("장바구니 상품 삭제 실패1");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
		}else if(select.equals("all")) {	// 장바구니 비우기를 선택한 경우
			int n = dao.deleteAll(mem_id);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
			}else {
				// 오류처리
				System.out.println("장바구니 비우기 실패");
			}
		}else if(select.equals("one")) {	// 삭제할 데이터를 직접 선택한 경우
			int basket_num = Integer.parseInt(req.getParameter("basket_num"));
			int n = dao.delete(basket_num);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/basketList.do");
			}else {
				// 오류처리
				System.out.println("장바구니 상품 삭제 실패2");
			}
		}
	}
}
