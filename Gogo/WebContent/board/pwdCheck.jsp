<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<form method="post" action = "${cp }/board/qnaDetail">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "qna_num" value = "${qna_num }">
		<h3>비밀번호 입력</h3>
		<input type = "password" name = "pwd"><br>
		<div style="color: red; font-size: 12px;">${msg }</div>
		<input type = "submit" value = "확인">
		<input type = "button" value = "취소" onclick = "javascript:history.go(-1)">
	</form>
</div>