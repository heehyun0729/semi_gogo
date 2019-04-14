<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<form method="post" action="${cp }/board/qnaDelete">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "qna_num" value = "${qna_num }">
		<p>글을 정말로 삭제할까요?</p>
		<input type = "submit" value = "삭제">
		<input type = "button" value = "취소" onclick="javascript:history.go(-1);">
	</form>
</div>