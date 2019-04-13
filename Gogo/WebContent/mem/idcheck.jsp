<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="gogo.mem.vo.MemVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gogo.mem.dao.MemDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("id");

	MemDao dao = MemDao.getInstance();
	ArrayList<MemVo> list = dao.list();
	
	JSONObject json = new JSONObject();
	json.put("msg", "사용 가능한 아이디입니다.");
	for(MemVo vo : list){
		if(id.equals(vo.getMem_id())){
			json.put("msg", "이미 존재하는 아이디입니다.");
		}
	}
	for(int i = 0 ; i < id.length() ; i++){
		char ch = id.charAt(i);
		if(!(ch >= 'a' && ch <= 'z') && !(ch >= '0' && ch <= '9')){
			json.put("msg", "아이디는 영문 소문자와 숫자로만 이루어져야 합니다.");
		}
	}
	if(id.length() < 4 || id.length() > 15){
		json.put("msg", "아이디는 4~15자 사이여야 합니다.");
	}
	
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.print(json.toString());
%>