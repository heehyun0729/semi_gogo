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
		int freedom_num=Integer.parseInt(req.getParameter("freedoum_num"));
		System.out.println(freedom_num);
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));
		String keywrod=req.getParameter("keyword");
		String field=req.getParameter("field");
		FreedomDao dao=new FreedomDao();
		FreedomVo vo=dao.detail(freedom_num);
		req.setAttribute("vo", vo);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("field", field);
		req.getRequestDispatcher("/freedom/freedom.jsp").forward(req,resp);
		}
}
//