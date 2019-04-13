package gogo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.order.vo.BuyVo;
import gogo.order.vo.DetailBuyVo;
import gogo.order.vo.OrderListVo;

public class DetailBuyDao {
	private static DetailBuyDao instance = new DetailBuyDao();
	private DetailBuyDao() {}
	public static DetailBuyDao getInstance() {
		return instance;
	}
	public int getCnt(String mem_id, String startDate, String endDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(detailBuy_num), 0) " + 
					"from detailBuy d, buy b, pay p " + 
					"where b.buy_num = d.buy_num and b.mem_id = ? " + 
					"    and b.buy_num = p.buy_num and p.pay_stat = 1"
					+ "  and to_char(b.buy_bdate, 'yyyy-mm-dd') >= ? and to_char(b.buy_bdate, 'yyyy-mm-dd') <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, startDate);
			pstmt.setString(3, endDate);
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
	public ArrayList<OrderListVo> orderList(String mem_id, int startRow, int endRow, String startDate, String endDate){
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from" + 
					"( " + 
					"    select AA.*, (price * cnt) tot, rownum rnum from " + 
					"    ( " + 
					"        select b.buy_num buy_num, b.buy_bdate buy_bdate, d.prod_num prod_num, p.menu_num menu_num, i.img_saveImg img_saveImg, " + 
					"             p.prod_name prod_name, d.op_num op_num, o.op_name op_name,  " + 
					"                d.detailop_num detailop_num, do.detailop_name detailop_name, do.detailop_price detailop_price, " + 
					"                (p.prod_price + do.detailop_price) price, d.detailBuy_cnt cnt " + 
					"        from buy b, detailBuy d, product p, image i, op o, detailOp do, pay p " + 
					"        where b.buy_num = d.buy_num  " + 
					"            and d.prod_num = p.prod_num " + 
					"            and p.menu_num = i.menu_num and p.prod_num = i.img_bnum " + 
					"            and i.img_type = 0 " + 
					"            and p.prod_num = o.op_num " + 
					"            and o.op_num = do.detailOp_num " + 
					"            and b.mem_id = ? " + 
					"            and b.buy_num = p.buy_num and p.pay_stat = 1 "
					+ "			and to_char(b.buy_bdate, 'yyyy-mm-dd') >= ? and to_char(b.buy_bdate, 'yyyy-mm-dd') <= ?"
					+ "		order by b.buy_num desc" + 
					"    )AA " + 
					") " + 
					"where rnum >= ? and rnum <= ?  "
					+ "";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, startDate);
			pstmt.setString(3, endDate);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			rs = pstmt.executeQuery();
			ArrayList<OrderListVo> list = new ArrayList<OrderListVo>();
			while(rs.next()) {
				String sql1 = "select count(buy_num) from detailBuy where buy_num = ?";
				pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, rs.getInt("buy_num"));
				rs1 = pstmt1.executeQuery();
				rs1.next();
				int length = rs1.getInt(1);
				OrderListVo vo = new OrderListVo(
							rs.getInt("buy_num"),
							rs.getDate("buy_bdate"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveImg"),
							rs.getString("prod_name"),
							rs.getString("op_name"),
							rs.getString("detailOp_name"),
							rs.getInt("detailOp_price"),
							rs.getInt("price"),
							rs.getInt("cnt"),
							rs.getInt("tot"),
							length
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
}
