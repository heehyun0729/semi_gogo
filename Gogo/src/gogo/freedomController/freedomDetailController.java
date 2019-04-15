package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;
import gogo.freedom.FreedomVo;

@WebServlet("/freedom/freedomDetail.do")
public class freedomDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int freedom_num=Integer.parseInt(req.getParameter("freedom_num"));
		System.out.println(freedom_num);
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));
		String keyword=req.getParameter("keyword");
		String field=req.getParameter("field");
		FreedomDao dao=new FreedomDao();
		FreedomVo vo=dao.detail(freedom_num);
		req.setAttribute("vo", vo);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("keyword",keyword);
		req.setAttribute("field", field);
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/freedom/freedomDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/freedom/freedomDetail.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/freedom/freedomDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}