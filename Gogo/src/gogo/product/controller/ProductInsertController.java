package gogo.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.op.dao.DetailOpDao;
import gogo.op.dao.OpDao;
import gogo.op.vo.DetailOpVo;
import gogo.op.vo.OpVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/admin/product/productInsert")
public class ProductInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("spage", "/admin/product/productInsert.jsp");
		req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dir = getServletContext().getRealPath("/upload/product");
		System.out.println(dir);
		MultipartRequest mr = new MultipartRequest(
					req,
					dir,
					1024 * 1024 * 20,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
		
		boolean ok = true;	// 모든 과정이 잘 되었나 확인
		
		ProductDao pdao = ProductDao.getInstance();
		int prod_num = pdao.getMaxNum() + 1;	// 상품번호 받아오기
		// product 테이블에 DB 추가
		int menu_num = Integer.parseInt(mr.getParameter("menu"));
		String name = mr.getParameter("name");
		int price = Integer.parseInt(mr.getParameter("price"));
		ProductVo vo = new ProductVo(prod_num, menu_num, name, price, 0);
		int n = pdao.insert(vo);
		if(n <= 0) {
			// 오류 처리
			ok = false;
			System.out.println("product DB 추가 실패");
		}
		
		// op 테이블에 DB 추가
		OpDao odao = OpDao.getInstance();
		DetailOpDao ddao = DetailOpDao.getInstance();
		String op_name = mr.getParameter("op");
		int op_num = odao.getMaxNum() + 1;
		if(op_name != null && !op_name.equals("")) {
			OpVo ovo = new OpVo(op_num, prod_num, op_name);
			int n1 = odao.insert(ovo);
			if(n1 <= 0) {
				// 오류 처리
				ok = false;
				System.out.println("op DB 추가 실패1");
			}
			// detailOp 테이블에 DB 추가
			String[] detailOps = mr.getParameterValues("detailOp");
			String[] detailOpPrices = mr.getParameterValues("detailOpPrice");
			for(int i = 0 ; i < detailOps.length ; i++) {
				int detailOp_price = Integer.parseInt(detailOpPrices[i]);
				DetailOpVo dvo = new DetailOpVo(0, op_num, detailOp_price, detailOps[i]);
				int n2 = ddao.insert(dvo);
				if(n2 <= 0) {
					// 오류 처리
					ok = false;
					System.out.println("detailOp DB 추가 실패1");
				}	
			}
		}else {	// 옵션 없는 경우
			OpVo ovo = new OpVo(op_num, prod_num, name);
			int n1 = odao.insert(ovo);
			if(n1 <= 0) {
				// 오류 처리
				ok = false;
				System.out.println("op DB 추가 실패2");
			}
			DetailOpVo dvo = new DetailOpVo(0, op_num, 0, name);
			int n2 = ddao.insert(dvo);
			if(n2 <= 0) {
				// 오류 처리
				ok = false;
				System.out.println("detailOp DB 추가 실패2");
			}
		}
		
		// 이미지 테이블에 이미지 추가
		ImageDao idao = ImageDao.getInstance();
		// 썸네일 이미지 추가
		String orgFileName = mr.getOriginalFileName("img");
		String saveFileName = mr.getFilesystemName("img");
		ImageVo ivo = new ImageVo(0, 0, orgFileName, saveFileName, menu_num, prod_num);
		int n3 = idao.insert(ivo);
		if(n3 <= 0) {
			// 오류 처리
			ok = false;
			System.out.println("썸네일 이미지 DB 삽입 오류");
		}
		// 상품 이미지 추가
		for(int i = 1 ; i <= 3 ; i++) {
			String ofn = mr.getOriginalFileName("pimg" + i);
			if(ofn != null && !ofn.equals("")) {
				String sfn = mr.getFilesystemName("pimg" + i);
				ImageVo ivo1 = new ImageVo(0, 1, ofn, sfn, menu_num, prod_num);
				int n4 = idao.insert(ivo1);
				if(n4 <= 0) {
					// 오류 처리
					ok = false;
					System.out.println("상품 이미지 DB 삽입 오류");
				}
			}
		}
		// 상세 이미지 추가
		for(int i = 1 ; i <= 3 ; i++) {
			String ofn = mr.getOriginalFileName("dimg" + i);
			if(ofn != null && !ofn.equals("")) {
				String sfn = mr.getFilesystemName("dimg" + i);
				ImageVo ivo1 = new ImageVo(0, 2, ofn, sfn, menu_num, prod_num);
				int n4 = idao.insert(ivo1);
				if(n4 <= 0) {
					// 오류 처리
					ok = false;
					System.out.println("상세 이미지 DB 삽입 오류");
				}
			}
		}
		// 모든 과정이 잘 끝났으면 목록으로 이동
		if(ok) {
			resp.sendRedirect(req.getContextPath() + "/product/productDetail.do?menu_num=" + menu_num + "&prod_num=" + prod_num);
		}
	}
}