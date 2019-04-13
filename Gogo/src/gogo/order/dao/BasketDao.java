package gogo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.order.vo.BasketListVo;
import gogo.order.vo.BasketVo;

public class BasketDao {
	private static BasketDao instance = new BasketDao();
	private BasketDao() {}
	public static BasketDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(basket_num), 0) from basket";
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
	public int insert(BasketVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			int num = getMaxNum() + 1;
			String sql = "insert into basket values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, vo.getMem_id());
			pstmt.setInt(3,vo.getProd_num());
			pstmt.setInt(4, vo.getOp_num());
			pstmt.setInt(5, vo.getDetailop_num());
			pstmt.setInt(6, vo.getBasket_cnt());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public ArrayList<BasketListVo> list(String mem_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select AA.*, (price * cnt) tot from " + 
					"    ( " + 
					"        select b.basket_num basket_num, b.prod_num prod_num, p.menu_num menu_num, i.img_saveimg img_saveimg, " + 
					"            p.prod_name prod_name, b.op_num op_num, o.op_name op_name, " + 
					"            b.detailop_num detailop_num, d.detailop_name detailop_name, d.detailop_price detailop_price, " + 
					"            (p.prod_price + d.detailop_price) price, b.basket_cnt cnt " + 
					"        from basket b, product p, image i, op o, detailop d " + 
					"        where b.prod_num = p.prod_num and p.prod_stat = 0 " + 
					"            and p.menu_num = i.menu_num and p.prod_num = i.img_bnum " + 
					"            and i.img_type = 0 " + 
					"            and b.op_num = o.op_num " + 
					"            and b.detailop_num = d.detailop_num " + 
					"            and b.mem_id = ? " + 
					"     )AA";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			ArrayList<BasketListVo> list = new ArrayList<BasketListVo>();
			while(rs.next()) {
				BasketListVo vo = new BasketListVo(
							rs.getInt("basket_num"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveimg"),
							rs.getString("prod_name"),
							rs.getInt("op_num"),
							rs.getString("op_name"),
							rs.getInt("detailOp_num"),
							rs.getString("detailOp_name"),
							rs.getInt("detailOp_price"),
							rs.getInt("price"),
							rs.getInt("cnt"),
							rs.getInt("tot")
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
	public ArrayList<BasketVo> getBasket(String mem_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from basket where mem_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			ArrayList<BasketVo> list = new ArrayList<BasketVo>();
			while(rs.next()) {
				BasketVo vo = new BasketVo(
							rs.getInt("basket_num"),
							mem_id,
							rs.getInt("prod_num"),
							rs.getInt("op_num"),
							rs.getInt("detailop_num"),
							rs.getInt("basket_cnt")
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
	public int isAdded(BasketVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from basket "
					+ "	where mem_id = ? and prod_num = ? and op_num = ? and detailop_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setInt(2, vo.getProd_num());
			pstmt.setInt(3, vo.getOp_num());
			pstmt.setInt(4, vo.getDetailop_num());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
			return 0;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public int updateCnt(BasketVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update basket set basket_cnt = basket_cnt + ? "
					+ "	where mem_id = ? and prod_num = ? and op_num = ? and detailop_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getBasket_cnt());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setInt(3, vo.getProd_num());
			pstmt.setInt(4, vo.getOp_num());
			pstmt.setInt(5, vo.getDetailop_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int deleteAll(String mem_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from basket where mem_id = ?";
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
	public int delete(int basket_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from basket where basket_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, basket_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int update(int basket_num, int cnt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update basket set basket_cnt = ? where basket_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, basket_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
