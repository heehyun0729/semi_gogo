package gogo.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.image.dao.ImageDao;
import gogo.image.vo.ProdImgVo;
import gogo.product.ProductDao;

@WebServlet("/product/findProduct.do")
public class ProductFindController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		String keyword=req.getParameter("find_prod_name");
		System.out.println(keyword);
		int pageNum=1;
		if(spageNum != null && !spageNum.equals("")){
				pageNum=Integer.parseInt(spageNum);
		}
		
		int endRow=pageNum*8;
		int startRow=endRow-7;
		
		ProductDao dao=ProductDao.getInstance();
		dao.find_prod_list(startRow, endRow, keyword);
		
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ProdImgVo> list = idao.getFindImg(0, keyword, startRow, endRow);
		int pageCount=(int)Math.ceil(dao.getFindCount(keyword)/8.0);
		int startPageNum=((pageNum-1)/4)*4+1;
		int endPageNum=startPageNum+3;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		req.setAttribute("list", list);
//		req.setAttribute("pageCount", pageCount);
//		req.setAttribute("startPage", startPageNum);
//		req.setAttribute("endPage", endPageNum);
//		req.setAttribute("pageNum", pageNum);
//		System.out.println(pageNum);
		req.setAttribute("spage", "/product/productList.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
		
	}
}
