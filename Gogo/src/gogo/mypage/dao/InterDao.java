package gogo.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.mypage.vo.InterListVo;
import gogo.mypage.vo.InterVo;
import gogo.order.vo.BasketListVo;

public class InterDao {
	private static InterDao instance = new InterDao();
	private InterDao() {}
	public static InterDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(inter_num), 0) from inter";
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
	public int insert(InterVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			int num = getMaxNum() + 1;
			String sql = "insert into inter values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, vo.getMem_id());
			pstmt.setInt(3, vo.getProd_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int isAdded(InterVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from inter where mem_id = ? and prod_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setInt(2, vo.getProd_num());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 0;	// 이미 추가된 경우
			}
			return 1;	// 테이블에 없는 경우
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public ArrayList<InterListVo> list(String mem_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select b.inter_num inter_num, b.prod_num prod_num, p.menu_num menu_num, "
					+ "i.img_saveimg img_saveimg, p.prod_name prod_name, p.prod_price prod_price " + 
					"    from inter b, product p, image i " + 
					"    where b.prod_num = p.prod_num and p.prod_stat = 0" + 
					"        and p.menu_num = i.menu_num and p.prod_num = i.img_bnum " + 
					"        and i.img_type = 0 " + 
					"        and b.mem_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			ArrayList<InterListVo> list = new ArrayList<InterListVo>();
			while(rs.next()) {
				InterListVo vo = new InterListVo(
							rs.getInt("inter_num"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveimg"),
							rs.getString("prod_name"),
							rs.getInt("prod_price")
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
	public int deleteAll(String mem_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from inter where mem_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int delete(int inter_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from inter where inter_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inter_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
