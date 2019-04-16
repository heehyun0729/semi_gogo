<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id = "board">
	<form method="post" action="${cp }/admin/product/productDelete">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "prod_num" value = "${prod_num }">
		<p style="margin-left: 44%;margin-top: 100px;">글을 정말로 삭제할까요?</p>
		<div style="margin-left: 45%;margin-bottom: 100px;margin-top: 10px;">
			<input class="btn btn-primary" type = "submit" value = "삭제">
			<input class="btn btn-primary" type = "button" value = "취소" onclick="javascript:history.go(-1);">
		</div>
	</form>
</div>