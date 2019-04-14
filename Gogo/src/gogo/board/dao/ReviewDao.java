package gogo.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.board.vo.ReviewListVo;
import gogo.board.vo.ReviewVo;
import gogo.order.vo.ReviewProdListVo;

public class ReviewDao {
	private static ReviewDao instance = new ReviewDao();
	private ReviewDao() {}
	public static ReviewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(review_num), 0) from review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int max = rs.getInt(1);
			return max;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public int insert(ReviewVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into review values(?, ?, ?, ?, ?, ?, sysdate, 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getReview_num());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setInt(3, vo.getDetailBuy_num());
			pstmt.setString(4, vo.getReview_title());
			pstmt.setString(5, vo.getReview_content());
			pstmt.setInt(6, vo.getReview_star());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public ArrayList<ReviewListVo> list(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select r.review_num review_num, p.prod_num prod_num, p.menu_num menu_num, " + 
					"    i.img_saveImg img_saveImg, p.prod_name prod_name, o.op_name op_name, "
					+ "	do.detailOp_name detailOp_name, do.detailOp_price detailOp_price, r.mem_id mem_id, " + 
					"    r.review_title review_title, r.review_content review_content, r.review_star review_star, " + 
					"    r.review_like review_like, r.review_wdate review_wdate " + 
					"from review r, detailBuy d, product p, op o, detailOp do, image i " + 
					"where r.detailBuy_num = d.detailBuy_num " + 
					"    and d.prod_num = p.prod_num " + 
					"    and d.op_num = o.op_num " + 
					"    and d.detailOp_num = do.detailOp_num " + 
					"    and p.menu_num = i.menu_num and p.prod_num = i.img_bnum and i.img_type = 0 " + 
					"order by r.review_num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<ReviewListVo> list = new ArrayList<ReviewListVo>();
			while(rs.next()) {
				ReviewListVo vo = new ReviewListVo(
							rs.getInt("review_num"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveImg"),
							rs.getString("prod_name"),
							rs.getString("op_name"),
							rs.getString("detailOp_name"),
							rs.getInt("detailOp_price"),
							rs.getString("mem_id"),
							rs.getString("review_title"),
							rs.getString("review_content"),
							rs.getInt("review_star"),
							rs.getInt("review_like"),
							rs.getDate("review_wdate")
						);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public ReviewListVo detail(int review_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select r.review_num review_num, p.prod_num prod_num, p.menu_num menu_num, " + 
					"    i.img_saveImg img_saveImg, p.prod_name prod_name, o.op_name op_name, "
					+ "	do.detailOp_name detailOp_name, do.detailOp_price detailOp_price, r.mem_id mem_id, " + 
					"    r.review_title review_title, r.review_content review_content, r.review_star review_star, " + 
					"    r.review_like review_like, r.review_wdate review_wdate " + 
					"from review r, detailBuy d, product p, op o, detailOp do, image i " + 
					"where r.detailBuy_num = d.detailBuy_num " + 
					"    and d.prod_num = p.prod_num " + 
					"    and d.op_num = o.op_num " + 
					"    and d.detailOp_num = do.detailOp_num " + 
					"    and p.menu_num = i.menu_num and p.prod_num = i.img_bnum and i.img_type = 0 "
					+ "	 and r.review_num = ? " + 
					"order by r.review_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ReviewListVo vo = new ReviewListVo(
							rs.getInt("review_num"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveImg"),
							rs.getString("prod_name"),
							rs.getString("op_name"),
							rs.getString("detailOp_name"),
							rs.getInt("detailOp_price"),
							rs.getString("mem_id"),
							rs.getString("review_title"),
							rs.getString("review_content"),
							rs.getInt("review_star"),
							rs.getInt("review_like"),
							rs.getDate("review_wdate")
						);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public int like(int review_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update review set review_like = review_like + 1 where review_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
