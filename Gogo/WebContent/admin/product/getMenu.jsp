<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="gogo.menu.vo.MenuVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gogo.menu.dao.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int cate_num = Integer.parseInt(request.getParameter("cate_num"));
	MenuDao dao = MenuDao.getInstance();
	ArrayList<MenuVo> list = dao.list(cate_num);
	
	JSONArray arr = new JSONArray();
	for(MenuVo vo : list){
		JSONObject json = new JSONObject();
		json.put("menu_num", vo.getMenu_num());
		json.put("menu_name", vo.getMenu_name());
		json.put("cate_num", vo.getCate_num());
		arr.add(json);
	}
	
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw = response.getWriter();
	pw.print(arr.toString());
%>