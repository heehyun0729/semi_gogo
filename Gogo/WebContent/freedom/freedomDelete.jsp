<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>상세보기</h1>
<hr>
<table border="1" style="width:500px;">
	<tr>
		<td>작성번호</td>
		<td>${vo.freedom_num }
	<tr>
	<tr>
		<td>제목</td>
		<td>${vo.freedom_title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea cols="50" rows="5" disaleb="disabled">${vo.freedom_content }</textarea></td>
	</tr>
</table>
<hr>
<input type="button" value="목록" onclick="location.href='${cp }/freedom/freedomList.do?menu_num=${menu_num}&freedom_num=${vo.freedom_num }'">
