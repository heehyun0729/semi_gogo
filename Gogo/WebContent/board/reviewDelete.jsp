<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id = "board">
	<form method="post" action="${cp }/board/reviewDelete">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "review_num" value = "${review_num }">
		<p>���� ������ �����ұ��?</p>
		<input type = "submit" value = "����">
		<input type = "button" value = "���" onclick="javascript:history.go(-1);">
	</form>
</div>