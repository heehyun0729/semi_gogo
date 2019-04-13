<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board">
	<div>
		<div>
			<h1>Notice</h1><h3>공지사항</h3>
		</div>
		<div>
		<table border = "1" style = "width: 500px;">
			<tr>
				<td>번호</td>
				<td>${nvo.notice_num }</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<c:choose>
					<c:when test="${nvo.notice_cate=='0' }">
						<td>공지사항</td>
					</c:when>
					<c:when test="${nvo.notice_cate=='1' }">
						<td>이벤트</td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td>제목</td>
				<td>${nvo.notice_title }</td>
			</tr>
		</table>
		<table border = "1" style = "width: 500px;">
			<tr>
				<td>작성일 | ${nvo.notice_wdate } &nbsp; &nbsp; &nbsp; &nbsp; 조회수 | ${nvo.notice_hit }</td>
			</tr>
			<tr>
				<td>${nvo.notice_content }</td>
			</tr>
			<c:if test="${!empty ilist }">
				<tr>
					<td colspan = "2">
						<c:forEach var = "vo" items = "${ilist }">
							<img src = "${cp }/upload/notice/${vo.img_saveImg}" style = "width: 100px; height: 100px;">
						</c:forEach>
					</td>
				</tr>
			</c:if>
		</table>
		<input type="button" value="목록" onclick="location.href='${cp }/board/noticeList.do'">
		</div>
	</div>
</div>