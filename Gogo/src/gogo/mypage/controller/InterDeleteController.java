package gogo.mypage.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.JDBCUtil;
import gogo.mypage.dao.InterDao;

@WebServlet("/mypage/interDelete.do")
public class InterDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String select = req.getParameter("select");
		
		InterDao dao = InterDao.getInstance();
		if(select.equals("ck")) {	// ������ �����͸� üũ�ڽ��� ������ ���
			String[] nums = req.getParameterValues("check");
			if(nums != null) {
				for(String num : nums) {
					int inter_num = Integer.parseInt(num);
					int n = dao.delete(inter_num);
					if(n <= 0) {
						// ����ó��
						System.out.println("���ɻ�ǰ ���� ����1");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
		}else if(select.equals("all")){	// ���ɻ�ǰ ���⸦ ������ ���
			int n = dao.deleteAll(mem_id);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
			}else {
				// ����ó��
				System.out.println("���ɻ�ǰ ���� ����");
			}
		}else if(select.equals("one")){	// ������ �����͸� ���� ������ ���
			int inter_num = Integer.parseInt(req.getParameter("inter_num"));
			int n = dao.delete(inter_num);
			if(n > 0) {
				resp.sendRedirect(req.getContextPath() + "/mypage/interList.do");
			}else {
				// ����ó��
				System.out.println("���ɻ�ǰ ���� ����2");
			}
		}
	}
}
