<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "box">
	<div id = "logo">
			<h1><a href = "${cp }/admin/home">GOGO</a></h1>
			<h3>고장난 고양이</h3>
			<p>관리자페이지</p>
	</div>
	<ul>

		<li><a href = "${cp }/admin/mem/memList">회원관리</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=0">상품등록</a></li>
		<li><a>게시글관리</a></li>
		<li><a href = "${cp }/board/noticeList.do?menu_num=9">공지사항</a></li>
		<li><a href = "${cp }/board/qna?menu_num=10">Q&A</a></li>
		<li><a href = "${cp }">리뷰</a></li>
		<li><a>통계</a></li>
		<li><a href = "${cp }">회원</a></li>
		<li><a href = "${cp }">매출</a></li>
	</ul>
	<ul>
		<li><a href="${cp}/mem/logout">LOGOUT</a></li>
	</ul>
</div>