package gogo.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.NoticeDao;
import gogo.board.vo.NoticeVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.image.vo.ProdImgVo;
import gogo.menu.dao.MenuDao;
import gogo.op.dao.DetailOpDao;
import gogo.op.dao.OpDao;
import gogo.op.vo.DetailOpVo;
import gogo.op.vo.OpVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/product/productDetail.do")
public class ProductDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		int prod_num = Integer.parseInt(req.getParameter("prod_num"));
		
		ProductDao pdao = ProductDao.getInstance();
		ProductVo pvo = pdao.detail(prod_num);
		
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ProdImgVo> sumlist = idao.getImg(0,menu_num, prod_num);
		ArrayList<ProdImgVo> ilist = idao.getImg(1,menu_num, prod_num);
		ArrayList<ProdImgVo> dilist = idao.getImg(2,menu_num, prod_num);
		
		OpDao odao=OpDao.getInstance();
		OpVo opvo = odao.getOp(prod_num);
		DetailOpDao ddao=DetailOpDao.getInstance();
		ArrayList<DetailOpVo> doplist=ddao.list(opvo.getOp_num());
		
		// 메뉴 이름 얻어오기
		MenuDao mdao = MenuDao.getInstance();
		String menu_name = mdao.getMenuName(menu_num);
		String cate_name = mdao.getCateName(menu_num);
		
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("menu_name", menu_name);
		req.setAttribute("cate_name", cate_name);
		req.setAttribute("pvo", pvo);
		req.setAttribute("sumlist", sumlist);
		req.setAttribute("ilist", ilist);
		req.setAttribute("dilist", dilist);
		req.setAttribute("opvo", opvo);
		req.setAttribute("doplist", doplist);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/product/productDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")){	
			req.setAttribute("spage", "/admin/product/productDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("spage", "/product/productDetail.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
