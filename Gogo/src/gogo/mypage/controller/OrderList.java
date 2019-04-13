package gogo.mypage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.order.dao.BuyDao;
import gogo.order.dao.DetailBuyDao;
import gogo.order.vo.OrderListVo;

@WebServlet("/mypage/orderList")
public class OrderList extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String spageNum = req.getParameter("pageNum");
		
		String sDate = req.getParameter("startDate");
		String eDate = req.getParameter("endDate");

		Date date1 = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 60);
        Date date2 = calendar.getTime();
    
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String endDate = sf.format(date1);
		if(eDate != null && !eDate.equals("")) {
			endDate = eDate;
		}
		String startDate = sf.format(date2);
		if(sDate != null && !sDate.equals("")) {
			startDate = sDate;
		}
		
		int pageNum = 1; 
		if(spageNum != null && !spageNum.equals("")) {
				pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;

		DetailBuyDao dao = DetailBuyDao.getInstance();
		ArrayList<OrderListVo> list = dao.orderList(mem_id, startRow, endRow, startDate, endDate);
		
		int pageCnt = (int)Math.ceil(dao.getCnt(mem_id, startDate, endDate) / 10.0);
		int startPage = ((pageNum - 1) / 10) * 10 + 1;
		int endPage = startPage + 9;
		if(pageCnt < endPage) {
			endPage = pageCnt;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startRow", startRow);
		req.setAttribute("endRow", endRow);
		req.setAttribute("pageCnt", pageCnt);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		req.setAttribute("spage", "/mypage/orderList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
