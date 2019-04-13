package gogo.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.op.dao.OpDao;
import gogo.order.dao.BasketDao;
import gogo.order.vo.BasketVo;

@WebServlet("/order/basketInsert.do")
public class BasketInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		int prod_num = Integer.parseInt(req.getParameter("prod_num"));
		
		// 옵션
		BasketDao dao = BasketDao.getInstance();
		int op_num = Integer.parseInt(req.getParameter("op_num"));
		String[] detailOp = req.getParameterValues("detailOp_num");
		String[] basketCnt = req.getParameterValues("basket_cnt");
		if(detailOp != null && basketCnt != null) {
			for(int i = 0 ; i < detailOp.length ; i++) {
				int detailOp_num = Integer.parseInt(detailOp[i]);
				int basket_cnt = Integer.parseInt(basketCnt[i]);
				BasketVo vo = new BasketVo(0, mem_id, prod_num, op_num, detailOp_num, basket_cnt);
				int added = dao.isAdded(vo);
				if(added == 0) { // 새로운 상품이면 추가
					int n = dao.insert(vo);
					if(n <= 0) {
						// 오류 처리
						System.out.println("장바구니 추가 실패");
					}
				}else if(added == 1){ // 이미 추가된 상품이면 수량 수정
					int n = dao.updateCnt(vo);
					if(n <= 0) {
						// 오류 처리
						System.out.println("장바구니 추가 실패");
					}
				}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/order/basketList.do");
	}
}
