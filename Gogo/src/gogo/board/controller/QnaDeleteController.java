package gogo.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gogo.board.dao.QnaDao;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/qnaDelete")
public class QnaDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("menu_num", menu_num);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
		if(id.equals("admin")) {
			req.setAttribute("spage", "/admin/board/qnaDelete.jsp");
			req.getRequestDispatcher("/admin/home.jsp").forward(req, resp);
		}else {
			String qna_num = req.getParameter("qna_num");
			req.setAttribute("qna_num", qna_num);
			req.setAttribute("spage", "/board/qnaDelete.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		String select = req.getParameter("select");
		
		ImageDao idao = ImageDao.getInstance();
		QnaDao qdao = QnaDao.getInstance();
		
		if(select != null) {	// ������ �����͸� üũ�ڽ��� ������ ���
			String[] qna_nums = req.getParameterValues("check");
			if(qna_nums != null) {
				for(String num : qna_nums) {
					int qn = Integer.parseInt(num);
					ArrayList<ImageVo> list = idao.list(menu_num, qn);
					if(list != null) {
						for(ImageVo vo : list) {
							File f = new File(getServletContext().getRealPath("/upload/qna/" + vo.getImg_saveImg()));
							if(!f.delete()) {
								// ���� ó��
								System.out.println("����� �̹��� ���� ����");
							}
						}
					}
					// image ���̺� DB ����
					int n = idao.delete(menu_num, qn);
					if(n <= 0) {
						// ���� ó��
						System.out.println("image DB ���� ����");
					}
					// qna ���̺� DB ����
					int n1 = qdao.delete(qn);
					if(n1 <= 0) {
						// ���� ó��
						System.out.println("qna DB ���� ����");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/board/qna?menu_num=" + menu_num);
		}else {	// ������ �����͸� ���� ������ ���
			int qna_num = Integer.parseInt(req.getParameter("qna_num"));
			// ����� �̹��� ����
			ArrayList<ImageVo> list = idao.list(menu_num, qna_num);
			if(list != null) {
				for(ImageVo vo : list) {
					File f = new File(getServletContext().getRealPath("/upload/qna/" + vo.getImg_saveImg()));
					if(!f.delete()) {
						// ���� ó��
						System.out.println("����� �̹��� ���� ����");
					}
				}
			}
			// image ���̺� DB ����
			int n = idao.delete(menu_num, qna_num);
			if(n <= 0) {
				// ���� ó��
				System.out.println("image DB ���� ����");
			}
			// qna ���̺� DB ����
			int n1 = qdao.delete(qna_num);
			if(n1 <= 0) {
				// ���� ó��
				System.out.println("qna DB ���� ����");
			}else {
				resp.sendRedirect(req.getContextPath() + "/board/qna?menu_num=" + menu_num);
			}
		}
	}
}
