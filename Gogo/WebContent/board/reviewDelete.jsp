<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div id = "board">
	<form method="post" action="${cp }/board/reviewDelete">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "review_num" value = "${review_num }">
		<p>글을 정말로 삭제할까요?</p>
		<input type = "submit" value = "삭제">
		<input type = "button" value = "취소" onclick="javascript:history.go(-1);">
	</form>
</div>