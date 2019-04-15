package gogo.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.board.vo.NoticeVo;

//
public class ProductDao {
	private static ProductDao instance = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {
		return instance;
	}
	
	public int getCount(int menu_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(prod_num),0) cnt from product where menu_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, menu_num);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
			return cnt;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	
	public int getFindCount(String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(prod_num),0) cnt from product where prod_stat = 0 and prod_name like '%"+keyword+"%'";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
			return cnt;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	
	public int delete(int prod_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DB.JDBCUtil.getConn();
			String sql="update product set prod_stat = 1 where prod_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,prod_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DB.JDBCUtil.close(con, pstmt,null);
		}	
	}
	
	public ArrayList<ProductVo> list(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ProductVo> list=new ArrayList<ProductVo>();
		try {
			con=DB.JDBCUtil.getConn();
			String sql = "select * from (" + 
					"    select AA.*, rownum rnum from" + 
					"    (" + 
					"        select * from product"
					+ "		where prod_stat = 0 " + 
					"        order by prod_num desc" + 
					"    )AA" + 
					" )" + 
					"where rnum>=? and rnum<=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo= new ProductVo( 
						rs.getInt("prod_num"),
						rs.getInt("menu_num"),
						rs.getString("prod_name"),
						rs.getInt("prod_price"),
						rs.getInt("prod_stat")
						);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DB.JDBCUtil.close(con, pstmt, rs);
		}
	}
	public ArrayList<ProductVo> find_prod_list(int startRow, int endRow, String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ProductVo> list=new ArrayList<ProductVo>();
		try {
			con=DB.JDBCUtil.getConn();
			String sql = "select * from ( " + 
					"    select AA.*, rownum rnum from " + 
					"    ( " + 
					"        select * from product " +
					"		 where prod_stat = 0 and prod_name like '%" + keyword + "%' " + 
					"        order by prod_num desc " + 
					"    )AA " + 
					" ) " + 
					"where rnum>=? and rnum<=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo= new ProductVo( 
						rs.getInt("prod_num"),
						rs.getInt("menu_num"),
						rs.getString("prod_name"),
						rs.getInt("prod_price"),
						rs.getInt("prod_stat")
						);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DB.JDBCUtil.close(con, pstmt, rs);
		}
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(prod_num), 0) from product";
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
	public int insert(ProductVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DB.JDBCUtil.getConn();
			int num = getMaxNum() + 1;
			String sql="insert into product values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2,vo.getMenu_num());
			pstmt.setString(3,vo.getProd_name());
			pstmt.setInt(4,vo.getProd_price());
			pstmt.setInt(5, vo.getProd_stat());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DB.JDBCUtil.close(con, pstmt,null);
		}	
	}
	public ProductVo detail(int prod_num) {
		Connection con= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = JDBCUtil.getConn();
			String sql="select * from product where prod_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prod_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ProductVo vo = new ProductVo(
						rs.getInt("prod_num"),
						rs.getInt("menu_num"),
						rs.getString("prod_name"),
						rs.getInt("prod_price"),
						rs.getInt("prod_stat")
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
	public int update(ProductVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DB.JDBCUtil.getConn();
			String sql="update product set menu_num = ?, prod_name = ?, prod_price = ? where prod_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getMenu_num());
			pstmt.setString(2,vo.getProd_name());
			pstmt.setInt(3,vo.getProd_price());
			pstmt.setInt(4, vo.getProd_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DB.JDBCUtil.close(con, pstmt,null);
		}	
	}
}



