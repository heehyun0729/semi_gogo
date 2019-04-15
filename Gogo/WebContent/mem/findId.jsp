<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<h1>아이디 찾기</h1>
	<form method="post" action="${cp }/mem/findId.do">
	<table>
		<tr>
			<th>NAME</th><td><input type="text" name="mem_name"></td>
		</tr>
		<tr>
			<th>Email</th><td><input type="text" name="mem_email"></td>
		</tr>
		<tr>
			<td><input type="submit" value="ID찾기"></td>
		</tr>
	</table>
	<div style="color:red;font-size:12px;">${msg }</div>
	</form>
</div>