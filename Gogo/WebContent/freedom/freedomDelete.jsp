<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id = "board">
	<form method="post" >
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "freedom_num" value = "${freedom_num }">
		<p>글을 정말로 삭제할까요?</p>
		<input type = "submit" value = "삭제">
		<input type = "button" value = "취소" onclick="javascript:history.go(-1);">
	</form>
</div>
<!--  -->