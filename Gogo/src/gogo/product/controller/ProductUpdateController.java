package gogo.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.board.dao.QnaDao;
import gogo.board.vo.QnaVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.op.dao.DetailOpDao;
import gogo.op.dao.OpDao;
import gogo.op.vo.DetailOpVo;
import gogo.op.vo.OpVo;
import gogo.product.ProductDao;
import gogo.product.ProductVo;

@WebServlet("/admin/product/productUpdate")
public class ProductUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int prod_num = Integer.parseInt(req.getParameter("prod_num"));
		
		ProductDao dao = ProductDao.getInstance();
		ProductVo vo = dao.detail(prod_num);
		
		OpDao odao = OpDao.getInstance();
		int op_num = odao.getOp(prod_num).getOp_num();
		String op_name = odao.getOp(prod_num).getOp_name();
		DetailOpDao ddao = DetailOpDao.getInstance();
		ArrayList<DetailOpVo> dlist = ddao.list(op_num);
		
		req.setAttribute("vo", vo);
		req.setAttribute("op_name", op_name);
		req.setAttribute("dlist", dlist);
		req.setAttribute("spage", "/admin/product/productUpdate.jsp");
		req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ο� ���� ���ε�
		String dir = getServletContext().getRealPath("/upload/product");
		MultipartRequest mr = new MultipartRequest(
				req,
				dir,
				1024 * 1024 * 5,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
		
		boolean ok = true;	// ��� ������ �� �Ǿ��� Ȯ��
		
		ProductDao pdao = ProductDao.getInstance();
		// product ���̺� DB ����
		int prod_num = Integer.parseInt(mr.getParameter("prod_num"));
		int menu_num = Integer.parseInt(mr.getParameter("menu"));
		String name = mr.getParameter("name");
		int price = Integer.parseInt(mr.getParameter("price"));
		ProductVo pvo = new ProductVo(prod_num, menu_num, name, price, 0);
		int n = pdao.update(pvo);
		if(n <= 0) {
			// ���� ó��
			ok = false;
			System.out.println("product DB ���� ����");
		}
		
		// op ���̺� DB ����
		OpDao odao = OpDao.getInstance();
		int op_num = odao.getOp(prod_num).getOp_num();
		DetailOpDao ddao = DetailOpDao.getInstance();
		int n1 = ddao.delete(op_num);
		if(n1 <= 0) {
			// ���� ó��
			ok = false;
			System.out.println("detailOp DB ���� ����");
		}
		int n2 = odao.delete(prod_num);
		if(n2 <= 0) {
			// ���� ó��
			ok = false;
			System.out.println("op DB ���� ����");
		}
		
		// op ���̺� DB �߰�
		String op_name = mr.getParameter("op");
		int op_num1 = odao.getMaxNum() + 1;
		if(op_name != null && !op_name.equals("")) {
			OpVo ovo = new OpVo(op_num1, prod_num, op_name);
			int n3 = odao.insert(ovo);
			if(n3 <= 0) {
				// ���� ó��
				ok = false;
				System.out.println("op DB �߰� ����1");
			}
			// detailOp ���̺� DB �߰�
			String[] detailOps = mr.getParameterValues("detailOp");
			String[] detailOpPrices = mr.getParameterValues("detailOpPrice");
			for(int i = 0 ; i < detailOps.length ; i++) {
				int detailOp_price = Integer.parseInt(detailOpPrices[i]);
				DetailOpVo dvo = new DetailOpVo(0, op_num1, detailOp_price, detailOps[i]);
				int n4 = ddao.insert(dvo);
				if(n4 <= 0) {
					// ���� ó��
					ok = false;
					System.out.println("detailOp DB �߰� ����1");
				}	
			}
		}else {	// �ɼ� ���� ���
			OpVo ovo = new OpVo(op_num1, prod_num, name);
			int n3 = odao.insert(ovo);
			if(n3 <= 0) {
				// ���� ó��
				ok = false;
				System.out.println("op DB �߰� ����2");
			}
			DetailOpVo dvo = new DetailOpVo(0, op_num, 0, name);
			int n4 = ddao.insert(dvo);
			if(n4 <= 0) {
				// ���� ó��
				ok = false;
				System.out.println("detailOp DB �߰� ����2");
			}
		}
		
		// ���� �̹��� ���� ����
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> list = idao.list(menu_num, prod_num);
		if(list != null) {
			for(ImageVo vo : list) {
				File f = new File(getServletContext().getRealPath("/upload/product/" + vo.getImg_saveImg()));
				if(!f.delete()) {
					// ���� ó��
					System.out.println("����� �̹��� ���� ����");
				}
			}
			// �̹��� ���̺� DB ����
			int n3 = idao.delete(menu_num, prod_num);
			if(n3 <= 0) {
				// ���� ó��
				System.out.println("image DB ���� ����");
			}
		}
		
		// �̹��� ���̺� �̹��� �߰�
		// ����� �̹��� �߰�
		String orgFileName = mr.getOriginalFileName("img");
		String saveFileName = mr.getFilesystemName("img");
		ImageVo ivo = new ImageVo(0, 0, orgFileName, saveFileName, menu_num, prod_num);
		int n3 = idao.insert(ivo);
		if(n3 <= 0) {
			// ���� ó��
			ok = false;
			System.out.println("����� �̹��� DB ���� ����");
		}
		// ��ǰ �̹��� �߰�
		for(int i = 1 ; i <= 3 ; i++) {
			String ofn = mr.getOriginalFileName("pimg" + i);
			if(ofn != null && !ofn.equals("")) {
				String sfn = mr.getFilesystemName("pimg" + i);
				ImageVo ivo1 = new ImageVo(0, 1, ofn, sfn, menu_num, prod_num);
				int n4 = idao.insert(ivo1);
				if(n4 <= 0) {
					// ���� ó��
					ok = false;
					System.out.println("��ǰ �̹��� DB ���� ����");
				}
			}
		}
		// �� �̹��� �߰�
		for(int i = 1 ; i <= 3 ; i++) {
			String ofn = mr.getOriginalFileName("dimg" + i);
			if(ofn != null && !ofn.equals("")) {
				String sfn = mr.getFilesystemName("dimg" + i);
				ImageVo ivo1 = new ImageVo(0, 2, ofn, sfn, menu_num, prod_num);
				int n4 = idao.insert(ivo1);
				if(n4 <= 0) {
					// ���� ó��
					ok = false;
					System.out.println("�� �̹��� DB ���� ����");
				}
			}
		}
		// ��� ������ �� �������� ������� �̵�
		if(ok) {
			resp.sendRedirect(req.getContextPath() + "/product/productDetail.do?menu_num=" + menu_num + "&prod_num=" + prod_num);
		}
	}
}
