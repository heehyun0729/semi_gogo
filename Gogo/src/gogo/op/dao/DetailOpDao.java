package gogo.op.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.op.vo.DetailOpVo;
import gogo.op.vo.OpVo;

public class DetailOpDao {
	private static DetailOpDao instance = new DetailOpDao();
	private DetailOpDao() {}
	public static DetailOpDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(detailOp_num), 0) from detailOp";
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
	public int insert(DetailOpVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			int num = getMaxNum() + 1;
			String sql = "insert into detailOp values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, vo.getOp_num());
			pstmt.setInt(3, vo.getDetailOp_price());
			pstmt.setString(4, vo.getDetailOp_name());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public ArrayList<DetailOpVo> list(int op_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from detailop where op_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op_num);
			rs = pstmt.executeQuery();
			ArrayList<DetailOpVo> list = new ArrayList<DetailOpVo>();
			while(rs.next()) {
				DetailOpVo vo = new DetailOpVo(
							rs.getInt("detailop_num"),
							rs.getInt("op_num"),
							rs.getInt("detailop_price"),
							rs.getString("detailop_name")
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
	public int delete(int op_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from detailop where op_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
