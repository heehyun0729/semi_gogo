package gogo.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.order.vo.BuyListVo;
import gogo.order.vo.BuyVo;
import gogo.order.vo.OrderListVo;

public class BuyDao {
	private static BuyDao instance = new BuyDao();
	private BuyDao() {}
	public static BuyDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(buy_num), 0) from buy";
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
	public int insert(BuyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into buy values(?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getBuy_num());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getBuy_addr());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public ArrayList<BuyListVo> list(String mem_id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select AA.*, (price * cnt) tot from " + 
					"( " + 
					"    select b.buy_num buy_num, d.prod_num prod_num, p.menu_num menu_num, i.img_saveImg img_saveImg, " + 
					"         p.prod_name prod_name, d.op_num op_num, o.op_name op_name, " + 
					"            d.detailop_num detailop_num, do.detailop_name detailop_name, do.detailop_price detailop_price, " + 
					"            (p.prod_price + do.detailop_price) price, d.detailBuy_cnt cnt " + 
					"    from buy b, detailBuy d, product p, image i, op o, detailOp do, (select max(buy_num) max_num from buy) m " + 
					"    where b.buy_num = d.buy_num " + 
					"        and d.prod_num = p.prod_num " + 
					"        and p.menu_num = i.menu_num and p.prod_num = i.img_bnum " + 
					"        and i.img_type = 0 " + 
					"        and p.prod_num = o.op_num " + 
					"        and o.op_num = do.detailOp_num " + 
					"        and b.mem_id = ? " + 
					"        and b.buy_num = m.max_num " + 
					")AA";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			ArrayList<BuyListVo> list = new ArrayList<BuyListVo>();
			while(rs.next()) {
				BuyListVo vo = new BuyListVo(
							rs.getInt("buy_num"),
							rs.getInt("prod_num"),
							rs.getInt("menu_num"),
							rs.getString("img_saveImg"),
							rs.getString("prod_name"),
							rs.getString("op_name"),
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
	public int update(BuyVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update buy set buy_addr = ? where buy_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getBuy_addr());
			pstmt.setInt(2, vo.getBuy_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
