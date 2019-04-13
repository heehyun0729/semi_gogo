<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>Q&A</h1>
	<h3>문의</h3>
	<table border = "1" style = "width: 500px;">
		<tr>
			<td>제목</td>
			<td>${qvo.qna_title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${qvo.mem_id }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${qvo.qna_wdate }</td>
		</tr>
		<tr>
			<td colspan = "2"><textarea rows = "10" cols = "80" readonly="readonly">${qvo.qna_content }</textarea></td>
		</tr>
		<c:if test="${!empty ilist }">
			<tr>
				<td colspan = "2">
					<c:forEach var = "vo" items = "${ilist }">
						<img src = "${cp }/upload/qna/${vo.img_saveImg}" style = "width: 100px; height: 100px;">
					</c:forEach>
				</td>
			</tr>
		</c:if>
	</table>
	<a href = "javascript:history.go(-2)">목록</a>
	<c:if test="${sessionScope.mem_id == qvo.mem_id }">
		<a href = "${cp }/board/qnaUpdate?menu_num=${menu_num}&qna_num=${qvo.qna_num}">수정</a>
		<a href = "${cp }/board/qnaDelete?menu_num=${menu_num}&qna_num=${qvo.qna_num}">삭제</a>
	</c:if>
	<c:if test="${sessionScope.mem_id == 'admin'}">
		<a href = "${cp }/board/qnaInsert?menu_num=${menu_num}&qna_num=${qvo.qna_num}">답글</a>
	</c:if>
</div>