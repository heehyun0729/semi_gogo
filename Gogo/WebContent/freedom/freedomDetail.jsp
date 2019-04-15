<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board">
	<div>
		<div>
			<h1>상세보기</h1>
		</div>
		<div>
		<table border="1" style="width:500px;">
			<tr>
				<td>작성번호</td>
				<td>${vo.freedom_num }
			</tr>
			<tr>
				<td>제목</td>
				<td>${vo.freedom_title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="5" disaleb="disabled">${vo.freedom_content }</textarea></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${vo.freedom_wdate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${vo.freedom_hit }</td>
			</tr>		
		</table>
		<input type="button" value="목록" onclick="location.href='${cp }/freedom/freedomList.do?menu_num=${menu_num}&freedom_num=${vo.freedom_num }'">
		</div>
	</div>
</div>		