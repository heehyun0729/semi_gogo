<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id = "board">
	<form method="post" action="${cp }/freedom/freedomDelete.do">
		<input type = "hidden" name = "menu_num" value = "${param.menu_num }">
		<input type = "hidden" name = "freedom_num" value = "${param.freedom_num }">
		<p style="margin-left: 50%">글을 정말로 삭제할까요?</p>
		<div style="margin-left: 50%">
			<input class="btn btn-primary" type = "submit" value = "삭제" >
			<input class="btn btn-primary" type = "button" value = "취소" onclick="javascript:history.go(-1);">
		</div>
	</form>
</div>
<!--  -->