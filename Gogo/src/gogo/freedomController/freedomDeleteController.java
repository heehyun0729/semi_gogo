package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;

@WebServlet("/freedom/freedomDelete.do")
public class freedomDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		String freedom_num = req.getParameter("freedom_num");
		//int freedom_num = Integer.parseInt(req.getParameter("freedom_num"));
		//System.out.println("freedom_num1:" + freedom_num);
//		FreedomDao dao=FreedomDao.getInstance();
//		System.out.println("dao:" + dao);
////		int n = dao.delete(freedom_num);
////		if(n <= 0) {
//			// 오류 처리
//			System.out.println("freedom DB 삭제 실패");
//		}else {
//		resp.sendRedirect(req.getContextPath() + "/freedom/freedomDelete.jsp?freedom_num=" + freedom_num);
//		}
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("freedom_num", freedom_num);
		req.setAttribute("spage", "/freedom/freedomDelete.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	//
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int freedom_num = Integer.parseInt(req.getParameter("freedom_num"));
//		String freedom_num =req.getParameter("freedom_num");
//		System.out.println("freedom_num:" + freedom_num);
			FreedomDao dao=FreedomDao.getInstance();
			int n = dao.delete(freedom_num);
			if(n <= 0) {
				// 오류 처리
				System.out.println("freedom DB 삭제 실패");
			}else {
				resp.sendRedirect(req.getContextPath() + "/freedom/freedomList.do?freedom_num=" + freedom_num);
			}
		}
		
	}