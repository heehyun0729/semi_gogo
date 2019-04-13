package gogo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.board.vo.QnaVo;

public class QnaDao {
	private static QnaDao instance = new QnaDao();
	private QnaDao() {}
	public static QnaDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(max(qna_num), 0) from qna";
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
	public QnaVo detail(int qna_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from qna where qna_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaVo vo = new QnaVo(
							qna_num,
							rs.getString("mem_id"),
							rs.getString("qna_cate"),
							rs.getString("qna_title"),
							rs.getString("qna_content"),
							rs.getString("qna_pwd"),
							rs.getDate("qna_wdate"),
							rs.getInt("qna_ref"),
							rs.getInt("qna_level"),
							rs.getInt("qna_step")
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
	public int getCnt(String mem_id, String field, String keyword, String cate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(qna_num), 0) from qna ";
			if(cate != null && !cate.equals("")) {
				sql += "where qna_cate like '" + cate + "' ";
				if(mem_id != null && !mem_id.equals("")) {
					sql += "and mem_id = '" + mem_id + "'";
				}
			}else if(mem_id != null && !mem_id.equals("")) {
				sql += "where mem_id = '" + mem_id + "'";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			return cnt;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	public int delete(int qna_num) {
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from qna where qna_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int update(QnaVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update qna set qna_cate = ?, qna_title = ?, qna_content = ?, qna_pwd = ? "
					+ "where qna_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getQna_cate());
			pstmt.setString(2, vo.getQna_title());
			pstmt.setString(3, vo.getQna_content());
			pstmt.setString(4, vo.getQna_pwd());
			pstmt.setInt(5, vo.getQna_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int insert(QnaVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		try {
			con = JDBCUtil.getConn();
			int snum = getMaxNum() + 1;
			int num = vo.getQna_num();
			int ref = vo.getQna_ref();
			int lev = vo.getQna_level();
			int step = vo.getQna_step();
			if(num == 0) {	// 새글일 때
				ref = snum;
			}else {	// 답글일 때
				String sql1 = "update qna set qna_step = qna_step + 1 where qna_ref = ? and qna_step > ?";
				pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, ref);
				pstmt1.setInt(2, step);
				pstmt1.executeUpdate();
				
				lev++;
				step++;
			}
			num = snum;
			String sql = "insert into qna values(?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getQna_cate());
			pstmt.setString(4, vo.getQna_title());
			pstmt.setString(5, vo.getQna_content());
			pstmt.setString(6, vo.getQna_pwd());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, lev);
			pstmt.setInt(9, step);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public ArrayList<QnaVo> list(int startRow, int endRow, String field, String keyword, String cate){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "";
			if(field == null && keyword == null) {
				sql = "select AA.*, rpad(substr(mem_id, 1, 3), length(mem_id), '*') id from " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna "+
						"        order by qna_ref desc, qna_step asc" + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ? ";
			}else if(field.equals("all")){
				sql = "select AA.*, rpad(substr(mem_id, 1, 3), length(mem_id), '*') id from " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna " + 
						"		 where qna_title like '%" + keyword + "%' or qna_content like '%" + keyword + "%' " + 
						"        order by qna_ref desc, qna_step asc " + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ? ";
			}else {
				sql = "select AA.*, rpad(substr(mem_id, 1, 3), length(mem_id), '*') id from " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna " + 
						"		 where " + field + " like '%" + keyword + "%' " + 
						"        order by qna_ref desc, qna_step asc " + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ? ";
			}
			if(cate != null && !cate.equals("")) {
				sql += "and qna_cate like '" + cate + "' ";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<QnaVo> list = new ArrayList<QnaVo>();
			while(rs.next()) {
				QnaVo vo = new QnaVo(
							rs.getInt("qna_num"),
							rs.getString("id"),
							rs.getString("qna_cate"),
							rs.getString("qna_title"),
							rs.getString("qna_content"),
							rs.getString("qna_pwd"),
							rs.getDate("qna_wdate"),
							rs.getInt("qna_ref"),
							rs.getInt("qna_level"),
							rs.getInt("qna_step")
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

	public ArrayList<QnaVo> list(String mem_id, int startRow, int endRow, String field, String keyword, String cate){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "";
			if(field == null && keyword == null) {
				sql = "select AA.* from " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna "+
						"        order by qna_ref desc, qna_step asc" + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ? and mem_id = '" + mem_id + "'";
			}else if(field.equals("all")){
				sql = "select AA.* from " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna " + 
						"		 where qna_title like '%" + keyword + "%' or qna_content like '%" + keyword + "%' " + 
						"        order by qna_ref desc, qna_step asc " + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ?  and mem_id = '" + mem_id + "'";
			}else {
				sql = "select AA.* " + 
						"( " + 
						"	 select BB.*, rownum rnum from " + 
						"     ( " + 
						"        select * from qna " + 
						"		 where " + field + " like '%" + keyword + "%' " + 
						"        order by qna_ref desc, qna_step asc " + 
						"     )BB " + 
						")AA " + 
						"where rnum >= ? and rnum <= ?  and mem_id = '" + mem_id + "'";
			}
			if(cate != null && !cate.equals("")) {
				sql += "and qna_cate like '" + cate + "' ";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<QnaVo> list = new ArrayList<QnaVo>();
			while(rs.next()) {
				QnaVo vo = new QnaVo(
							rs.getInt("qna_num"),
							rs.getString("mem_id"),
							rs.getString("qna_cate"),
							rs.getString("qna_title"),
							rs.getString("qna_content"),
							rs.getString("qna_pwd"),
							rs.getDate("qna_wdate"),
							rs.getInt("qna_ref"),
							rs.getInt("qna_level"),
							rs.getInt("qna_step")
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
