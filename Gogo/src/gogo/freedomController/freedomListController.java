package gogo.freedomController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.freedom.FreedomDao;
import gogo.freedom.FreedomVo;

@WebServlet("/freedom/freedomList.do")
public class freedomListController extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String spageNum=req.getParameter("pageNum");
	String field=req.getParameter("field");
	String keyword=req.getParameter("keyword");
	String pvo=req.getParameter("pvo");
	
	int pageNum=1;
	if(spageNum!=null) {
		pageNum=Integer.parseInt(spageNum);
	}
	int startRow=(pageNum-1)*10+1;
	int endRow=startRow+9;
	FreedomDao dao=new FreedomDao();
	ArrayList<FreedomVo> list=dao.list(startRow, endRow,field,keyword);
	System.out.println("list1....:" + list);
	int pageCount=(int)Math.ceil(dao.getCount(field,keyword)/10.0);
	System.out.println("pageCount:" + pageCount);
	int startPage=(pageNum-1)/10*10+1;
	int endPage=startPage+9;
	if(endPage>pageCount) {
		endPage=pageCount;
	}
	req.setAttribute("list", list);
	req.setAttribute("pageCount", pageCount);
	req.setAttribute("startPage", startPage);
	req.setAttribute("endPage", endPage);
	req.setAttribute("pageNum", pageNum);
	req.setAttribute("keyword", keyword);
	req.setAttribute("pvo", pvo);
	
	String id = (String)req.getSession().getAttribute("mem_id");
	if(id == null || id.equals("")) {
		req.setAttribute("spage", "/freedom/freedomList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}else if(id.equals("admin")) {
		req.setAttribute("spage", "/admin/freedom/freedomList.jsp");
		req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
	}else {
		req.setAttribute("spage", "/freedom/freedomList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
}