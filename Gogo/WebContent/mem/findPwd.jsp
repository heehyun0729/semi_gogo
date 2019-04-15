<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<h1>비밀번호 찾기</h1>
	<form method="post" action="${cp }/mem/findPwd.do">
	<table>
		<tr>
			<th>ID</th><td><input type="text" name="mem_id"></td>
		</tr>
		<tr>
			<th>Email</th><td><input type="text" name="mem_email"></td>
		</tr>
		<tr>
			<td><input type="submit" value="비밀번호찾기"></td>
		</tr>
	</table>
	<div style="color:red;font-size:12px;">${msg }</div>
	</form>
</div>