package gogo.mypage.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.JDBCUtil;
import gogo.mypage.dao.InterDao;

@WebServlet("/mypage/interDelete.do")
public class InterDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String select = req.getParameter("select");
		
		InterDao dao = InterDao.getInstance();
		if(select.equals("ck")) {	// 삭제할 데이터를 체크박스로 선택한 경우
			String[] nums = req.getParameterValues("check");
			if(nums != null) {
				for(String num : nums) {
					int inter_num = Integer.parseInt(num);
					int n = dao.delete(inter_num);
					if(n <= 0) {
						// 오류처리
						System.out.println("관심상품 삭제 실패1");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
		}else if(select.equals("all")){	// 관심상품 비우기를 선택한 경우
			int n = dao.deleteAll(mem_id);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
			}else {
				// 오류처리
				System.out.println("관심상품 비우기 실패");
			}
		}else if(select.equals("one")){	// 삭제할 데이터를 직접 선택한 경우
			int inter_num = Integer.parseInt(req.getParameter("inter_num"));
			int n = dao.delete(inter_num);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
			}else {
				// 오류처리
				System.out.println("관심상품 삭제 실패2");
			}
		}
	}
}
