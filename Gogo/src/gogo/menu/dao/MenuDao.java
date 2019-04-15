package gogo.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.menu.vo.MenuVo;

public class MenuDao {
	private static MenuDao instance = new MenuDao();
	private MenuDao() {}
	public static MenuDao getInstance() {
		return instance;
	}
	public ArrayList<MenuVo> list(int cate_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from menu "
					+ "where cate_num = ? "
					+ "order by menu_num";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			rs = pstmt.executeQuery();
			ArrayList<MenuVo> list = new ArrayList<MenuVo>();
			while(rs.next()) {
				MenuVo vo = new MenuVo(
							rs.getInt("menu_num"),
							rs.getString("menu_name"),
							cate_num
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
	public String getMenuName(int menu_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from menu where menu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getString("menu_name");
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
}
