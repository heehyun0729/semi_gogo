package gogo.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.board.vo.NoticeVo;
import gogo.board.vo.QnaVo;

public class NoticeDao {
	private static NoticeDao instance = new NoticeDao();
	private NoticeDao() {}
	public static NoticeDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(max(notice_num),0) MAXNUM from notice";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int maxnum=rs.getInt("MAXNUM");
			return maxnum;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	public int getMaxHit(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(max(notice_hit),0) HITNUM from notice where notice_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			int hitnum=rs.getInt("HITNUM");
			return hitnum;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	public int getCount(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(notice_num),0) cnt from notice ";
			if(!(field==null || field.equals(""))) {
				if(field.equals("notice_content") || field.equals("notice_title")) {
					sql += "where " + field + " like '%" + keyword + "%'";
				}else if(field.equals("notice_all")) {
					sql += "where notice_title like '%" + keyword + "%' OR notice_content like '%" + keyword + "%'";
				}
			}
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
	public ArrayList<NoticeVo> list(int startRow,int endRow,String cate,String field,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=JDBCUtil.getConn();
			String sql="";
			if(field==null || field.equals("")) {
				sql="select * from(" + 
						" select AA.*, rownum rnum from " + 
						" (" + 
						" select * from notice " + 
						" order by notice_step,notice_wdate desc" + 
						" )AA" + 
						")" + 
						"where rnum>=? and rnum<=?";
			}else if(field.equals("notice_content") || field.equals("notice_title")){
				sql="select * from(" + 
						" select AA.*, rownum rnum from " + 
						" (" + 
						" select * from notice " + 
						"where " + field + " like '%" + keyword + "%'" + 
						" order by notice_step,notice_wdate desc" + 
						" )AA" + 
						")" + 
						"where rnum>=? and rnum<=?";
			}else if(field.equals("notice_all")){
				sql="select * from(" + 
						" select AA.*, rownum rnum from " + 
						" (" + 
						" select * from notice " + 
						"where notice_title like '%" + keyword + "%' OR notice_content like '%" + keyword + "%'" +
						" order by notice_step,notice_wdate desc" + 
						" )AA" + 
						")" + 
						"where rnum>=? and rnum<=?";
			}
			if(!(cate==null || cate.equals(""))) {
				sql="select * from(" + 
						" select AA.*, rownum rnum from " + 
						" (" + 
						" select * from notice " + 
						"where notice_cate=" + cate + 
						" order by notice_step,notice_wdate desc" + 
						" )AA" + 
						")" + 
						"where rnum>=? and rnum<=?";	
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			ArrayList<NoticeVo> list=new ArrayList<NoticeVo>();
			while(rs.next()) {
				int notice_num=rs.getInt("notice_num");
				String notice_title=rs.getString("notice_title");
				String notice_content=rs.getString("notice_content");
				Date notice_wdate=rs.getDate("notice_wdate");
				int notice_step=rs.getInt("notice_step");
				String notice_cate=rs.getString("notice_cate");
				int notice_hit=rs.getInt("notice_hit");
				
				NoticeVo vo=new NoticeVo(notice_num,notice_title,notice_content,notice_wdate,
						notice_step,notice_cate,notice_hit);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	public int insert(NoticeVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into notice values(?, ?, ?, sysdate, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNotice_num());
			pstmt.setString(2, vo.getNotice_title());
			pstmt.setString(3, vo.getNotice_content());
			pstmt.setInt(4, vo.getNotice_step());
			pstmt.setString(5, vo.getNotice_cate());
			pstmt.setInt(6, vo.getNotice_hit());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public NoticeVo detail(int notice_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		int hitnum=getMaxHit(notice_num)+1;
		String sql1 = "update notice set notice_hit=? where notice_num = ?";
		String sql = "select * from notice where notice_num = ?";
		
		try {
			con = JDBCUtil.getConn();
			
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1,hitnum);
			pstmt1.setInt(2,notice_num);
			int n=pstmt1.executeUpdate();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo vo = new NoticeVo(
							notice_num,
							rs.getString("notice_title"),
							rs.getString("notice_content"),
							rs.getDate("notice_wdate"),
							rs.getInt("notice_step"),
							rs.getString("notice_cate"),
							rs.getInt("notice_hit")
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
	public int delete(int notice_num) {
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from notice where notice_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	public int update(NoticeVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update notice set notice_title = ?, notice_content = ?, notice_step = ?, notice_cate= ? "
					+ "where notice_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getNotice_title());
			pstmt.setString(2, vo.getNotice_content());
			pstmt.setInt(3, vo.getNotice_step());
			pstmt.setString(4, vo.getNotice_cate());
			pstmt.setInt(5, vo.getNotice_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
}
