package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.QnaDao;
import gogo.board.vo.QnaVo;

@WebServlet("/board/qna")
public class QnaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String spageNum = req.getParameter("pageNum");
		
		String cate = req.getParameter("cate");
		
		String field = req.getParameter("field");
		String keyword = req.getParameter("keyword");
		
		int pageNum = 1; 
		if(spageNum != null && !spageNum.equals("")) {
				pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;
		
		QnaDao dao = QnaDao.getInstance();
		ArrayList<QnaVo> list = dao.list(startRow, endRow, field, keyword, cate);
		
		int pageCnt = (int)Math.ceil(dao.getCnt(null, field, keyword, cate) / 10.0);
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
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("cate", cate);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/board/qnaList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/board/qnaList.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/board/qnaList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
