package gogo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.board.dao.NoticeDao;
import gogo.board.dao.QnaDao;
import gogo.board.vo.NoticeVo;
import gogo.board.vo.QnaVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;

@WebServlet("/board/noticeInsert.do")
public class NoticeInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect(req.getContextPath()+"/board/noticeInsert.jsp");
		
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("menu_num", menu_num);
		req.setAttribute("spage", "/admin/board/noticeInsert.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		String dir = getServletContext().getRealPath("/upload/notice");
		MultipartRequest mr = new MultipartRequest(
					req,
					dir,
					1024 * 1024 * 5,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
		
		NoticeDao dao=NoticeDao.getInstance();
		int notice_num=dao.getMaxNum()+1;
		String notice_title=mr.getParameter("title");
		String notice_content=mr.getParameter("content");
		int notice_step=1;
		if(mr.getParameter("step")!=null) {
			notice_step=Integer.parseInt(mr.getParameter("step"));
		}
		String notice_cate=mr.getParameter("cate");
		int notice_hit=0;
		
		ImageDao dao1 = ImageDao.getInstance();
		for(int i = 1 ; i <= 3 ; i++) {
			String orgFileName = mr.getOriginalFileName("file" + i);
			if(orgFileName != null && !orgFileName.equals("")) {
				String saveFileName = mr.getFilesystemName("file" + i);
				ImageVo vo = new ImageVo(0, 0, orgFileName, saveFileName, 9, notice_num);
				int n = dao1.insert(vo);
				System.out.println("n:"+n);
				System.out.println("dir"+dir);
				if(n <= 0) {
					// 坷幅 贸府
				}
			}
		}
		
		NoticeVo vo=new NoticeVo(notice_num,notice_title,notice_content,null,notice_step,notice_cate,notice_hit);
		int n=dao.insert(vo);
		if(n>0) {
			resp.sendRedirect(req.getContextPath() + "/board/noticeList.do?menu_num="+menu_num);
		}else {
			// 坷幅贸府
		}
	}
}
