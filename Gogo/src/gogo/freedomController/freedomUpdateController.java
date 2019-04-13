package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;

@WebServlet("/freedom/freedomUpdate")
public class freedomUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int freedom_num=Integer.parseInt(req.getParameter("freedom_num"));
		FreedomDao dao=FreedomDao.getInstance();
	}
}
