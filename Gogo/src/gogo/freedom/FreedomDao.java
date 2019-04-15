package gogo.freedom;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.board.vo.NoticeVo;


//
public class FreedomDao {
	
	public ArrayList<FreedomVo> list(int startRow,int endRow,String field,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="";
			if(field==null || field.equals("")) {
				sql="select * from("+
						" select aa.*,rownum rnum from( " + 
						   "  select * from freedom order by freedom_wdate desc" +
						   " )aa " + 
						   ") where rnum>=? and rnum<=?";
				}else {
					sql="select * from(" + 
						"  select aa.*,rownum rnum from(" + 
						"     select * from freedom " + 
						"     where " + field +" like '%" + keyword +"%'" + 
						"     order by freedom_wdate desc) aa" + 
						") where rnum>=? and rnum<=?";
				}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<FreedomVo> list=new ArrayList<FreedomVo>();
			while(rs.next()) {
				int freedom_num=rs.getInt("freedom_num");
				String freedom_title=rs.getString("freedom_title");
				String freedom_content=rs.getString("freedom_content");
				Date freedom_wdate=rs.getDate("freedom_wdate");
				int freedom_hit=rs.getInt("freedom_hit");
				
				FreedomVo vo=new FreedomVo(freedom_num,freedom_title,freedom_content,freedom_wdate,freedom_hit);
				list.add(vo);
			}
			System.out.println("list:"+ list);
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			JDBCUtil.close(con,pstmt,rs);
		}
	}
	
	public int getMaxHit(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(max(freedom_hit),0) HITNUM from freedom where freedom_num=?";
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
	
	public FreedomVo detail(int freedom_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1 = null;
		ResultSet rs=null;
		
		int hitnum=getMaxHit(freedom_num)+1;
		String sql1="update freedom set freedom_hit=? where freedom_num=?";
		String sql="select *from freedom where freedom_num=?";
		try {
			con = JDBCUtil.getConn();
			
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1,hitnum);
			pstmt1.setInt(2,freedom_num);
			int n=pstmt1.executeUpdate();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, freedom_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FreedomVo vo = new FreedomVo(
							freedom_num,
							rs.getString("freedom_title"),
							rs.getString("notice_content"),
							rs.getDate("freedom_wdate"),
							rs.getInt("freedom_step")
							
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
	
	public int update(FreedomVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="update freedom set freedom_title=?,freedom_content=? where freedom_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getFreedom_num());
			pstmt.setString(2,vo.getFreedom_title());
			pstmt.setString(3, vo.getFreedom_content());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.close(con,pstmt,null);
		}
	}
	
	public int delete(int Freedom_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from freedom where freedom_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Freedom_num);
			return pstmt.executeUpdate();
			}catch(SQLException se){
				se.printStackTrace();
				return -1;
			}finally{
				JDBCUtil.close(con,pstmt,null);
			}						
	}
	public int insert(FreedomVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into Freedom values(fre.nextval,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getFreedom_title());
			 pstmt.setString(2, vo.getFreedom_content());
			pstmt.setInt(3,vo.getFreedom_hit());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.close(con,pstmt,null);
		}
	}

	public double getCount(String field, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(freedom_num),0) from freedom";
			if(field!=null && ! field.equals("")) {
				sql +="where"+ field + "like '%" + keyword + "%'";
			}
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
			System.out.println("cnt:" + cnt);
			return cnt;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
		JDBCUtil.close(con,pstmt,rs);
		}
	}

	public static FreedomDao getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
//
