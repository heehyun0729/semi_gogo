package gogo.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JDBCUtil;
import gogo.mem.vo.MemVo;

public class MemDao {
	private static MemDao instance=new MemDao();
	public MemDao() {}
	public static MemDao getInstance() {return instance;}
	////[회원전용]-[MYPAGE]-[회원탈퇴]
	public boolean delete(String mem_id,String mem_pwd) {
			Connection con=null;
			PreparedStatement pstmt=null;
			PreparedStatement pstmt1=null;
			ResultSet rs=null;
			boolean result=false;
			String dbpwd="";
			try {
				con=JDBCUtil.getConn();
				String sql="select mem_pwd from members where mem_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					dbpwd=rs.getString("mem_pwd");
					if(dbpwd.equals(mem_pwd)) {
						String delsql="update members set mem_stat=1 where mem_id=?";
						pstmt1=con.prepareStatement(delsql);
						pstmt1.setString(1, mem_id);
						pstmt1.executeUpdate();
						result=true;
					}
				}	
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				JDBCUtil.close(con, pstmt, rs);
			}
			return result;//결과값 리턴
		}
////[회원페이지] 비밀번호찾기
		public String findPwd(String mem_id, String mem_email) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String result=null;
			try {
				con=JDBCUtil.getConn();
				String sql="select mem_pwd from members where mem_id=? and mem_email=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				pstmt.setString(2, mem_email);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getString("mem_pwd");
					return result;
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				JDBCUtil.close(con, pstmt, rs);
			}
			return result;
		}
	////[회원페이지] ID찾기
		public String findId(String mem_name, String mem_email) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String result=null;
			try {
				con=JDBCUtil.getConn();
				String sql="select mem_id from members where mem_name=? and mem_email=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mem_name);
				pstmt.setString(2, mem_email);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getString("mem_id");
					return result;
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				JDBCUtil.close(con, pstmt, rs);
			}
			return result;
		}
	////[회원전용]-[MYPAGE]- 회원정보보기
		public MemVo getinfo(String mem_id) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JDBCUtil.getConn();
				String sql="select * from members where mem_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					MemVo vo=new MemVo(
							rs.getString("mem_id"),
							rs.getString("mem_pwd"),
							rs.getString("mem_name"),
							rs.getString("mem_phone"),
							rs.getString("mem_email"),
							rs.getString("mem_addr"),
							rs.getInt("mem_stat")
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
		//[관리자페이지]->[회원관리]->[수정]->회원정보 업데이트기능/
	public int update(MemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try { 
			con=JDBCUtil.getConn();
			String sql="update members set mem_pwd=?,mem_name=?,mem_phone=?,mem_email=?,mem_addr=?,mem_stat=? where mem_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_pwd());
			pstmt.setString(2, vo.getMem_name());
			pstmt.setString(3, vo.getMem_phone());
			pstmt.setString(4, vo.getMem_email());
			pstmt.setString(5, vo.getMem_addr());
			pstmt.setInt(6, vo.getMem_stat());
			pstmt.setString(7, vo.getMem_id());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	////[관리자페이지] gogo's 회원목록 페이징
	public ArrayList<MemVo> list(int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql="select * from (" +
					"select AA.*, rownum rnum from" +
					"	(" +
					"		select * from members" +
					"		order by mem_id desc" +
					"	)AA" +
					")" +
					"where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<MemVo> list = new ArrayList<MemVo>();
			while(rs.next()) {
				MemVo vo = new MemVo(
							rs.getString("mem_id"),
							rs.getString("mem_pwd"),
							rs.getString("mem_name"),
							rs.getString("mem_phone"),
							rs.getString("mem_email"),
							rs.getString("mem_addr"),
							rs.getInt("mem_stat")
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
	
	public ArrayList<MemVo> list(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql="select * from members";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<MemVo> list = new ArrayList<MemVo>();
			while(rs.next()) {
				MemVo vo = new MemVo(
							rs.getString("mem_id"),
							rs.getString("mem_pwd"),
							rs.getString("mem_name"),
							rs.getString("mem_phone"),
							rs.getString("mem_email"),
							rs.getString("mem_addr"),
							rs.getInt("mem_stat")
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
	
	////[관리자페이지] 회원목록 불러오는 count
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select NVL(count(mem_id),0) cnt from members";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
			return cnt;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	//// [회원페이지]신규 회원가입
	public int insert(MemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JDBCUtil.getConn();
			String sql="insert into members values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getMem_pwd());
			pstmt.setString(3, vo.getMem_name());
			pstmt.setString(4,vo.getMem_phone());
			pstmt.setString(5, vo.getMem_email());
			pstmt.setString(6, vo.getMem_addr());
			pstmt.setInt(7, vo.getMem_stat());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	////[회원페이지] login&pwd 회원검사
	public boolean isMem(String mem_id,String mem_pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from members where mem_id=? and mem_pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return false;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public int blockMem(String mem_id,String mem_pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int blockNum=0;
		try {
			con=JDBCUtil.getConn();
			String sql="select mem_stat from members where mem_id=? and mem_pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return blockNum=rs.getInt("mem_stat");
			}else {
				return -1;
			}
		}catch(SQLException se) {
			return -2;
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
}
