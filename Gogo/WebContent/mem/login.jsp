<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<h2>LOGIN</h2>
		<form method="post" action="${cp }/mem/login">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mem_id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mem_pwd"></td>
				</tr>
			</table>
			<div style="color:red;font-size:12px;">${errMsg }</div>
			<div style="color:red;font-size:12px;">${errMsg2 }</div>
			<div id="button">
				<input type="submit" value="로그인">
			</div>
			<div id="tag">
				<a href="${cp }/mem/join">회원가입</a><br>
				<a href="${cp }/mem/findId.do">아이디찾기</a> <a href="${cp }/mem/findPwd.jsp">비밀번호찾기</a>
			</div>
		</form> 
</div>