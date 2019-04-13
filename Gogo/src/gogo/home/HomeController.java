package gogo.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cp = req.getContextPath();
		getServletContext().setAttribute("cp", cp);
		
		req.setAttribute("spage", "/main.jsp");
		req.getRequestDispatcher("/home.jsp" ).forward(req, resp);
	}
}