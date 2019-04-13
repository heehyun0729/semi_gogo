<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<div>
		<h1>글수정하기</h1>
	</div>
	<form method="post" action="${cp }/board/noticeUpdate.do" enctype="multipart/form-data">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "notice_num" value = "${vo.notice_num }">
		<input type = "hidden" name = "notice_hit" value = "${vo.notice_hit }">
		<table border = "1" style="width: 500px;">
			<tr>
				<td>카테고리</td>
				<td>
					<select name = "notice_cate">
						<option value = "0"
							<c:if test = "${vo.notice_cate == '0'}">
								selected = "selected"
							</c:if>
						>공지사항</option>
						<option value = "1"
							<c:if test = "${vo.notice_cate == '1'}">
								selected = "selected"
							</c:if>
						>이벤트</option>
					</select>
					&nbsp;&nbsp;&nbsp;중요한 공지<input type="checkbox" name="notice_step" value="0">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "notice_title" value = "${vo.notice_title }"></td>
			</tr>
			<tr>
				<td colspan = "2"><textarea rows = "10" cols = "80" name = "notice_content">${vo.notice_content }</textarea></td>
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
				<td colspan = "2">
					<input type = "submit" value = "수정">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>