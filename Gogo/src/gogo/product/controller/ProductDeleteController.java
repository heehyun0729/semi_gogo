package gogo.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.NoticeDao;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/admin/product/productDelete")
public class ProductDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		String prod_num = req.getParameter("prod_num");
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("prod_num", prod_num);
		req.setAttribute("spage", "/admin/product/productDelete.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		int prod_num = Integer.parseInt(req.getParameter("prod_num"));
		
		// product 테이블 DB 상태 수정
		ProductDao dao = ProductDao.getInstance();
		int n = dao.delete(prod_num);
		if(n <= 0) {
			// 오류 처리
			System.out.println("product DB 상태 수정 실패");
		}else {
			resp.sendRedirect(req.getContextPath() + "/product/productList.do?menu_num=" + menu_num);
		}
	}
	
}

