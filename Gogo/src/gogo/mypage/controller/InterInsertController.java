package gogo.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mypage.dao.InterDao;
import gogo.mypage.vo.InterVo;
import gogo.order.dao.BasketDao;
import gogo.order.vo.BasketVo;

@WebServlet("/mypage/interInsert.do")
public class InterInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		int prod_num = Integer.parseInt((String) req.getParameter("prod_num"));
		
		InterVo vo = new InterVo(0, mem_id, prod_num);
		InterDao dao = InterDao.getInstance();
		int n = dao.isAdded(vo);
		if(n == 0) {
			resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
		}else if(n == 1) {
			int n1 = dao.insert(vo);
			if(n1 > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
			}else {
				// 오류 처리
				System.out.println("관심상품 추가 실패");
			}
		}else {
			// 오류 처리
			System.out.println("관심상품 추가 실패");
		}
		
	}
}
