package gogo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gogo.board.dao.ReviewDao;
import gogo.board.vo.ReviewVo;
import gogo.image.dao.ImageDao;
import gogo.image.vo.ImageVo;
import gogo.order.dao.DetailBuyDao;
import gogo.order.vo.ReviewProdListVo;

@WebServlet("/board/reviewInsert")
public class ReviewInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String detailBuy_num = req.getParameter("detailBuy_num");
		String prod_name = req.getParameter("prod_name");
		String op_name = req.getParameter("op_name");
		String detailOp_name = req.getParameter("detailOp_name");
		String detailOp_price = req.getParameter("detailOp_price");
		
		DetailBuyDao dao = DetailBuyDao.getInstance();
		ArrayList<ReviewProdListVo> list = dao.reviewProdList(mem_id);
		
		req.setAttribute("detailBuy_num", detailBuy_num);
		req.setAttribute("prod_name", prod_name);
		req.setAttribute("op_name", op_name);
		req.setAttribute("detailOp_name", detailOp_name);
		req.setAttribute("detailOp_price", detailOp_price);
		req.setAttribute("list", list);
		req.setAttribute("spage", "/board/reviewInsert.jsp");
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dir = getServletContext().getRealPath("/upload/review");
		System.out.println(dir);
		MultipartRequest mr = new MultipartRequest(
					req,
					dir,
					1024 * 1024 * 5,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
		
		ReviewDao dao = ReviewDao.getInstance();
		int review_num = dao.getMaxNum() + 1;	// 리뷰 글번호 받아오기
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		int detailBuy_num = Integer.parseInt(mr.getParameter("prod"));
		String review_title = mr.getParameter("title");
		String review_content = mr.getParameter("content");
		int review_star = Integer.parseInt(mr.getParameter("star"));
		
		// 이미지 테이블에 이미지 추가
		ImageDao dao1 = ImageDao.getInstance();
		for(int i = 1 ; i <= 3 ; i++) {
			String orgFileName = mr.getOriginalFileName("file" + i);
			if(orgFileName != null && !orgFileName.equals("")) {
				String saveFileName = mr.getFilesystemName("file" + i);
				ImageVo vo = new ImageVo(0, 0, orgFileName, saveFileName, 11, review_num);
				int n = dao1.insert(vo);
				if(n <= 0) {
					// 오류 처리
					System.out.println("이미지삽입오류");
				}
			}
		}
		
		// review 테이블에 DB 추가
		ReviewVo vo = new ReviewVo(review_num, mem_id, detailBuy_num, review_title, review_content, review_star, null, 0);
		int n = dao.insert(vo);
		if(n <= 0){
			// 오류 처리
			System.out.println("review DB 추가 실패");
		}
		// detailBuy 테이블 review 상태 수정
		DetailBuyDao ddao = DetailBuyDao.getInstance();
		int n1 = ddao.update(detailBuy_num);
		if(n1 <= 0) {
			// 오류처리
			System.out.println("detailBuy DB 수정 실패");
		}
		resp.sendRedirect(req.getContextPath() + "/board/review");
	}
}
