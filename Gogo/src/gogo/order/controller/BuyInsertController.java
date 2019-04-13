package gogo.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BasketDao;
import gogo.order.dao.BuyDao;
import gogo.order.dao.DetailBuyDao;
import gogo.order.vo.BasketVo;
import gogo.order.vo.BuyVo;
import gogo.order.vo.DetailBuyVo;

@WebServlet("/order/buyInsert")
public class BuyInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("mem_id");
		String select = req.getParameter("select");
		
		boolean ok = true;

		BasketDao dao = BasketDao.getInstance();
		BuyDao bdao = BuyDao.getInstance();
		DetailBuyDao ddao = DetailBuyDao.getInstance();
		
		if(select.equals("all")) {	// 전체상품 주문
			// buy DB 추가
			int buy_num = bdao.getMaxNum() + 1;
			BuyVo bvo = new BuyVo(buy_num, id, null, null);
			int n = bdao.insert(bvo);
			if(n <= 0) {
				// 오류처리
				ok = false;
				System.out.println("buy DB 추가 실패1");
			}
			// 장바구니 상품목록 가져오기
			ArrayList<BasketVo> list = dao.getBasket(id);
			// 장바구니 상품목록을 detailBuy 테이블에 추가
			for(BasketVo vo : list) {
				DetailBuyVo dvo = new DetailBuyVo(
							0,
							buy_num,
							vo.getProd_num(),
							vo.getOp_num(),
							vo.getDetailop_num(),
							vo.getBasket_cnt()
						);
				int n1 = ddao.insert(dvo);
				if(n1 <= 0) {
					// 오류처리
					ok = false;
					System.out.println("detailBuy DB 추가 실패1");
				}
			}
		}else if(select.equals("ck")) {	// 선택상품 주문
			// 체크된 목록 가져오기
			
			// 상품목록을 detailBuy 테이블에 추가
		}else if(select.equals("one")) {	// 상품페이지에서 주문
			int prod_num = Integer.parseInt(req.getParameter("prod_num"));
			// buy DB 추가
			int buy_num = bdao.getMaxNum() + 1;
			BuyVo bvo = new BuyVo(buy_num, id, null, null);
			int n = bdao.insert(bvo);
			if(n <= 0) {
				// 오류처리
				ok = false;
				System.out.println("buy DB 추가 실패3");
			}
			// 옵션
			int op_num = Integer.parseInt(req.getParameter("op_num"));
			String[] detailOp = req.getParameterValues("detailOp_num");
			String[] basketCnt = req.getParameterValues("basket_cnt");
			if(detailOp != null && basketCnt != null) {
				for(int i = 0 ; i < detailOp.length ; i++) {
					int detailOp_num = Integer.parseInt(detailOp[i]);
					int basket_cnt = Integer.parseInt(basketCnt[i]);
					// 가져온 상품목록을 detailBuy 테이블에 추가
					DetailBuyVo dvo = new DetailBuyVo(
								0,
								buy_num,
								prod_num,
								op_num,
								detailOp_num,
								basket_cnt
							);
					int n1 = ddao.insert(dvo);
					if(n1 <= 0) {
						// 오류처리
						ok = false;
						System.out.println("detailBuy DB 추가 실패3");
					}
				}
			}
		}
		if(ok) {
			resp.sendRedirect(req.getContextPath() + "/order/buy");
		}
	}
}
