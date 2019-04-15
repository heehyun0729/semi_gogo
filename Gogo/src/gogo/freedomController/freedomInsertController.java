package gogo.freedomController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.freedom.FreedomDao;
import gogo.freedom.FreedomVo;


@WebServlet("/freedom/freedomInsert.do")
public class freedomInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("spage", "/freedom/freedomInsert.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dir = getServletContext().getRealPath("/upload/freedom");
		System.out.println(dir);
		MultipartRequest mr = new MultipartRequest(
					req,
					dir,
					1024 * 1024 * 20,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
		
		
		
		String freedom_title=mr.getParameter("freedom_title");
		String freedom_content=mr.getParameter("freedom_content");
		System.out.println("freedom_content:" + freedom_content);
		FreedomVo vo=new FreedomVo(0,freedom_title,freedom_content,null, 0);
		FreedomDao dao=new FreedomDao();
		int n=dao.insert(vo);
		if(n>0) {
			resp.sendRedirect(req.getContextPath() + "/freedom/freedomList.do");
		}else {
		
		}
	}
}
//
