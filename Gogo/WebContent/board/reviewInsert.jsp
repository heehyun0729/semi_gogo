<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<h1>REVIEW</h1>
	<h3>후기</h3>
	<form method="post" action="">
		<table border = "1" style = "width: 500px;">
			<tr>
				<td>구매한 상품</td>
				<td><select name = "prod" onclick="getProd('${cp}')"></select></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows = "5" cols = "50" name = "content"></textarea></td>
			</tr>
			<tr>
				<td>별점</td>
				<td>
					<input type = "radio" name = "star" value = "1">1
					<input type = "radio" name = "star" value = "2">2
					<input type = "radio" name = "star" value = "3">3
					<input type = "radio" name = "star" value = "4">4
					<input type = "radio" name = "star" value = "5" checked="checked">5
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "작성">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>