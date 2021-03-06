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
import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.order.dao.DetailBuyDao;

@WebServlet("/board/reviewDelete")
public class ReviewDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu_num = req.getParameter("menu_num");
		req.setAttribute("menu_num", menu_num);
		
		String id = (String)req.getSession().getAttribute("mem_id");
		if(id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else {
			String qna_num = req.getParameter("review_num");
			req.setAttribute("review_num", qna_num);
			req.setAttribute("spage", "/board/reviewDelete.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu_num = Integer.parseInt(req.getParameter("menu_num"));
		String select = req.getParameter("select");
		
		ImageDao idao = ImageDao.getInstance();
		ReviewDao rdao = ReviewDao.getInstance();
		DetailBuyDao ddao = DetailBuyDao.getInstance();
		
		if(select != null) {	// 삭제할 데이터를 체크박스로 선택한 경우
			String[] review_nums = req.getParameterValues("check");
			if(review_nums != null) {
				for(String num : review_nums) {
					int rn = Integer.parseInt(num);
					ArrayList<ImageVo> list = idao.list(menu_num, rn);
					if(list != null) {
						for(ImageVo vo : list) {
							File f = new File(getServletContext().getRealPath("/upload/review/" + vo.getImg_saveImg()));
							if(!f.delete()) {
								// 오류 처리
								System.out.println("저장된 이미지 삭제 실패1");
							}
						}
					}
					// image 테이블 DB 삭제
					int n = idao.delete(menu_num, rn);
					if(n <= 0) {
						// 오류 처리
						System.out.println("image DB 삭제 실패1");
					}
					// review 테이블 DB 삭제
					int n1 = rdao.delete(rn);
					if(n1 <= 0) {
						// 오류 처리
						System.out.println("review DB 삭제 실패1");
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/board/review?menu_num=" + menu_num);
		}else {	// 삭제할 데이터를 직접 선택한 경우
			int review_num = Integer.parseInt(req.getParameter("review_num"));
			// 저장된 이미지 삭제
			ArrayList<ImageVo> list = idao.list(menu_num, review_num);
			if(list != null) {
				for(ImageVo vo : list) {
					File f = new File(getServletContext().getRealPath("/upload/review/" + vo.getImg_saveImg()));
					if(!f.delete()) {
						// 오류 처리
						System.out.println("저장된 이미지 삭제 실패2");
					}
				}
			}
			// image 테이블 DB 삭제
			int n = idao.delete(menu_num, review_num);
			if(n <= 0) {
				// 오류 처리
				System.out.println("image DB 삭제 실패2");
			}
			// review 테이블 DB 삭제
			int n1 = rdao.delete(review_num);
			if(n1 <= 0) {
				// 오류 처리
				System.out.println("review DB 삭제 실패2");
			}
			// detailBuy 테이블 DB 수정
			ReviewVo rvo = rdao.getReview(review_num);
			int detailBuy_num = rvo.getDetailBuy_num();
			int n2 = ddao.update(detailBuy_num, 0);
			if(n2 <= 0) {
				// 오류 처리
				System.out.println("detailBuy DB 수정 실패");
			}else {
				resp.sendRedirect(req.getContextPath() + "/board/review?menu_num=" + menu_num);
			}
		}
	}
}
