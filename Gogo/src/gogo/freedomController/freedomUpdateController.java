package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;
import gogo.freedom.FreedomVo;

@WebServlet("/freedom/freedomUpdate")
public class freedomUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int freedom_num=Integer.parseInt(req.getParameter("freedom_num"));
		FreedomDao dao=FreedomDao.getInstance();
		FreedomVo vo=dao.detail(freedom_num);
		
		System.out.println(freedom_num);
		req.setAttribute("freedom_num", freedom_num);
		req.setAttribute("vo",vo);
		req.setAttribute("spage","/admin/freedom/freedomUpdate.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int freedom_num=Integer.parseInt(req.getParameter("freedom_num"));
		String freedom_title=req.getParameter("freedom_title ");
		String freedom_content=req.getParameter("freedom_content ");
		FreedomVo vo=new FreedomVo(freedom_num,freedom_title,freedom_content,null,0);
		FreedomDao dao=new FreedomDao();
	}
}
//
