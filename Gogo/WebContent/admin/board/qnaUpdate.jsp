<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>Q&A</h1>
	<h3>문의</h3>
	<p>관리자페이지</p>
	<form method="post" action="${cp }/board/qnaUpdate" enctype="multipart/form-data">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "qna_num" value = "${vo.qna_num }">
		<table border = "1" style="width: 500px;">
			<tr>
				<td>카테고리</td>
				<td>
					<select name = "cate">
						<option value = "prod"
							<c:if test = "${vo.qna_cate == 'prod'}">
								selected = "selected"
							</c:if>
						>상품</option>
						<option value = "ship"
							<c:if test = "${vo.qna_cate == 'ship'}">
								selected = "selected"
							</c:if>
						>배송</option>
						<option value = "cancel"
							<c:if test = "${vo.qna_cate == 'cancel'}">
								selected = "selected"
							</c:if>
						>교환/반품</option>
						<option value = "pay"
							<c:if test = "${vo.qna_cate == 'pay'}">
								selected = "selected"
							</c:if>
						>결제</option>
						<option value = "etc"
							<c:if test = "${vo.qna_cate == 'etc'}">
								selected = "selected"
							</c:if>
						>기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "title" value = "${vo.qna_title }"></td>
			</tr>
			<tr>
				<td colspan = "2"><textarea rows = "10" cols = "80" name = "content">${vo.qna_content }</textarea></td>
			</tr>
			<tr>
				<td>첨부파일1</td>
				<td><input type = "file" name = "file1"></td>
			</tr>
			<tr>
				<td>첨부파일2</td>
				<td><input type = "file" name = "file2"></td>
			</tr>
			<tr>
				<td>첨부파일3</td>
				<td><input type = "file" name = "file3"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd" disabled="disabled"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "수정">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>