package gogo.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.mypage.dao.InterDao;
import gogo.mypage.vo.InterListVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/mypage/interList.do")
public class InterController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		InterDao dao = InterDao.getInstance();
		ArrayList<InterListVo> list = dao.list(mem_id);
		
		req.setAttribute("list", list);
		req.setAttribute("spage", "/mypage/interList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
