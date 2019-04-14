<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="gogo.board.vo.ReviewListVo"%>
<%@page import="gogo.board.dao.ReviewDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int review_num = Integer.parseInt(request.getParameter("review_num"));

	ReviewDao dao = ReviewDao.getInstance();
	int n = dao.like(review_num);
	if(n > 0){
		ReviewListVo vo = dao.detail(review_num);
		int review_like = vo.getReview_like();
		JSONObject json = new JSONObject();
		json.put("review_like", review_like);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
	}
%>