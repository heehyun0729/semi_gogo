package gogo.board.controller;

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

import gogo.board.dao.NoticeDao;
import gogo.board.vo.NoticeVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
@WebServlet("/board/noticeUpdate.do")
public class NoticeUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		System.out.println("menu_num:"+menu_num);
		int notice_num = Integer.parseInt(req.getParameter("notice_num"));
		System.out.println("notice_num:"+notice_num);
		
		NoticeDao dao = NoticeDao.getInstance();
		NoticeVo vo = dao.detail(notice_num);
		
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("vo", vo);
		req.setAttribute("spage", "/admin/board/noticeUpdate.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ο� ���� ���ε�
		String dir = getServletContext().getRealPath("/upload/notice");
		MultipartRequest mr = new MultipartRequest(
				req,
				dir,
				1024 * 1024 * 5,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
		
		// image DB �߰�
		int notice_num=Integer.parseInt(mr.getParameter("notice_num"));
		int menu_num=Integer.parseInt(mr.getParameter("menu_num"));
		String notice_title=mr.getParameter("notice_title");
		String notice_content=mr.getParameter("notice_content");
		int notice_step=1;
		if(mr.getParameter("notice_step")!=null) {
			notice_step=Integer.parseInt(mr.getParameter("notice_step"));
		}
		String notice_cate=mr.getParameter("notice_cate");
		int notice_hit=Integer.parseInt(mr.getParameter("notice_hit"));
		
		// ���� ���� ����
		ImageDao idao = ImageDao.getInstance();
		ArrayList<ImageVo> list = idao.list(menu_num, notice_num);
		if(list != null) {
			for(ImageVo vo : list) {
				File f = new File(getServletContext().getRealPath("/upload/notice/" + vo.getImg_saveImg()));
				if(!f.delete()) {
					// ���� ó��
					System.out.println("����� �̹��� ���� ����");
				}
			}
		}
		
		// �̹��� ���̺� DB ����
		int n = idao.delete(menu_num, notice_num);
		if(n <= 0) {
			// ���� ó��
			System.out.println("image DB ���� ����");
		}
		
		// �̹��� ���̺� DB �߰�
		for(int i = 1 ; i <= 3 ; i++) {
			String orgFileName = mr.getOriginalFileName("file" + i);
			if(orgFileName != null && !orgFileName.equals("")) {
				String saveFileName = mr.getFilesystemName("file" + i);
				ImageVo vo = new ImageVo(0, 0, orgFileName, saveFileName, menu_num, notice_num);
				int n1 = idao.insert(vo);
				if(n1 <= 0) {
					// ���� ó��
					System.out.println("�̹��� DB ���� ����");
				}
			}
		}
		
		// notice DB ����
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeVo vo = new NoticeVo(notice_num,notice_title,notice_content,null,notice_step,notice_cate,notice_hit);
		int n2 = ndao.update(vo);
		if(n2 <= 0) {
			// ���� ó��
			System.out.println("notice DB ���� ����");
		}else {
			resp.sendRedirect(req.getContextPath() + "/board/noticeList.do?menu_num=" + menu_num);
		}
	}
}
