package gogo.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.image.vo.ProdImgVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/product/productList.do")
public class ProductListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("mem_id");
		String smenu_num = req.getParameter("menu_num");
		int menu_num = 0;
		if(smenu_num != null && !smenu_num.equals("")) {
			menu_num = Integer.parseInt(smenu_num);
		}
		String spageNum=req.getParameter("pageNum");
		String cate=req.getParameter("cate");
		
		int pageNum=1;
		if(spageNum != null && !spageNum.equals("")){
				pageNum=Integer.parseInt(spageNum);
		}
		
		int endRow=pageNum*8;
		int startRow=endRow-7;
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ProdImgVo> list = idao.getImg(0, menu_num, startRow, endRow);
		ProductDao dao = ProductDao.getInstance();
		int pageCount=(int)Math.ceil(dao.getCount(menu_num)/8.0);
		int startPageNum=((pageNum-1)/4)*4+1;
		int endPageNum=startPageNum+3;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPageNum);
		req.setAttribute("endPage", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("cate", cate);
		
		
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/product/productList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/product/productList.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/product/productList.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
		
		
	}
}
