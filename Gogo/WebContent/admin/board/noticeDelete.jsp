<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id = "board">
	<form method="post" action="${cp }/board/noticeDelete.do">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "notice_num" value = "${notice_num }">
		<p style="margin-left: 50%">글을 정말로 삭제할까요?</p>
		<div style="margin-left: 50%">
			<input class="btn btn-primary" type = "submit" value = "삭제">
			<input class="btn btn-primary" type = "button" value = "취소" onclick="javascript:history.go(-1);">
		</div>
	</form>
</div>