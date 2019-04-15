package gogo.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.image.vo.ImageVo;
import gogo.image.vo.ProdImgVo;

public class ImageDao {
	private static ImageDao instance = new ImageDao();
	private ImageDao() {}
	public static ImageDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(img_num), 0) from image";
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
	public ArrayList<ImageVo> list(int menu_num, int img_bnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from image where menu_num = ? and img_bnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu_num);
			pstmt.setInt(2, img_bnum);
			rs = pstmt.executeQuery();
			ArrayList<ImageVo> list = new ArrayList<ImageVo>();
			while(rs.next()) {
				ImageVo vo = new ImageVo(
							rs.getInt("img_num"),
							rs.getInt("img_type"),
							rs.getString("img_orgImg"),
							rs.getString("img_saveImg"),
							rs.getInt("menu_num"),
							rs.getInt("img_bnum")
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
	public ArrayList<ProdImgVo> getImg(int img_type, int menu_num, int img_bnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn(); 
			String sql = "select p.prod_num, p.menu_num, p.prod_name, p.prod_price, i.img_type, i.img_orgImg, i.img_saveImg " + 
					"from product p, image i " + 
					"where p.prod_num = i.img_bnum and p.menu_num = i.menu_num "
					+ "and i.img_type = ? and p.menu_num = ? and p.prod_num = ? and p.prod_stat = 0 ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, img_type);
			pstmt.setInt(2, menu_num);
			pstmt.setInt(3, img_bnum);
			rs = pstmt.executeQuery();
			ArrayList<ProdImgVo> list = new ArrayList<ProdImgVo>();
			while(rs.next()) {
				ProdImgVo vo = new ProdImgVo(
							img_bnum, 
							menu_num, 
							rs.getString("prod_name"),
							rs.getInt("prod_price"),
							img_type,
							rs.getString("img_orgImg"),
							rs.getString("img_saveImg")
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
	public ArrayList<ProdImgVo> getFindImg(int img_type, String keyword, int startRow, int endRow ) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from " + 
					"(" + 
					"select AA.*, rownum rnum from " + 
					"(" + 
					"select p.prod_num, p.menu_num, p.prod_name, p.prod_price, i.img_type, i.img_orgImg, i.img_saveImg " + 
					"from product p, image i " + 
					"where p.prod_num = i.img_bnum and p.menu_num = i.menu_num " + 
					"and i.img_type = ? and p.prod_name like '%"+keyword+"%' and p.prod_stat = 0" + 
					")AA" + 
					")" + 
					"where rnum >= ? and rnum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, img_type);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			ArrayList<ProdImgVo> list = new ArrayList<ProdImgVo>();
			while(rs.next()) {
				ProdImgVo vo = new ProdImgVo(
							rs.getInt(1), 
							rs.getInt(2),
							rs.getString(3),
							rs.getInt(4),
							img_type,
							rs.getString(6),
							rs.getString(7)
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
	public ArrayList<ProdImgVo> getImg(int img_type, int menu_num, int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from " + 
					"( " + 
					"    select AA.*, rownum rnum from " + 
					"    ( " + 
					"        select p.prod_num, p.menu_num, p.prod_name, p.prod_price, i.img_type, i.img_orgImg, i.img_saveImg " + 
					"        from product p, image i " + 
					"        where p.prod_num = i.img_bnum and p.menu_num = i.menu_num "
					+ "		 and i.img_type = ? and p.menu_num = ? and p.prod_stat = 0 " + 
					"    )AA " + 
					") " + 
					"where rnum >= ? and rnum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, img_type);
			pstmt.setInt(2, menu_num);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			ArrayList<ProdImgVo> list = new ArrayList<ProdImgVo>();
			while(rs.next()) {
				ProdImgVo vo = new ProdImgVo(
							rs.getInt(1), 
							menu_num, 
							rs.getString(3),
							rs.getInt(4),
							img_type,
							rs.getString(6),
							rs.getString(7)
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
	public int delete(int menu_num, int img_bnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from image where menu_num = ? and img_bnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu_num);
			pstmt.setInt(2, img_bnum);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int insert(ImageVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into image values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum() + 1);
			pstmt.setInt(2, vo.getImg_type());
			pstmt.setString(3, vo.getImg_orgImg());
			pstmt.setString(4, vo.getImg_saveImg());
			pstmt.setInt(5, vo.getMenu_num());
			pstmt.setInt(6, vo.getImg_bnum());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
