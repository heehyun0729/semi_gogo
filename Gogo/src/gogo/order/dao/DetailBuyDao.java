package gogo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.JDBCUtil;
import gogo.order.vo.BuyVo;
import gogo.order.vo.DetailBuyVo;

public class DetailBuyDao {
	private static DetailBuyDao instance = new DetailBuyDao();
	private DetailBuyDao() {}
	public static DetailBuyDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(detailbuy_num), 0) from detailbuy";
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
	public int insert(DetailBuyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			int num = getMaxNum() + 1;
			String sql = "insert into detailbuy values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, vo.getBuy_num());
			pstmt.setInt(3, vo.getProd_num());
			pstmt.setInt(4, vo.getOp_num());
			pstmt.setInt(5, vo.getDetailOp_num());
			pstmt.setInt(6, vo.getDetailBuy_cnt());
			int n= pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
