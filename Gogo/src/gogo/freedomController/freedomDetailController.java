package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;
import gogo.freedom.FreedomVo;

@WebServlet("/freedom/freedomDetail")
public class freedomDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int freedom_num=Integer.parseInt(req.getParameter("num"));
		FreedomDao dao=new FreedomDao();
		FreedomVo vo=dao.detail(freedom_num);
		
		int n=dao.delete(freedom_num);
		if(n>0) {
				resp.sendRedirect(req.getContextPath()+"freedom/freedomList");
		}else{
				req.setAttribute("resultCode", "fail");
				req.getRequestDispatcher("/freedom/freedomList.jsp").forward(req,resp);
		}
	}
}
//