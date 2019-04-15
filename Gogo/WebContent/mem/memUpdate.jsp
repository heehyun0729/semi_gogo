<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
<h1>회원 정보수정</h1>
<form method="post" action="${cp }/mypage/myInfo.do">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mem_id" value="${vo.mem_id }" disabled="disabled"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" name="mem_pwd" value="${vo.mem_pwd }"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th><td><input type="password" name="mem_pwd" value="${vo.mem_pwd }"></td>
		</tr>
		<tr>
			<th>회원이름</th><td><input type="text" name="mem_name" value="${vo.mem_name }"></td>
		</tr>
		<tr>
			<th>전화번호</th><td><input type="text" name="mem_phone" value="${vo.mem_phone }"></td>
		</tr>
		<tr>
			<th>Email</th><td><input type="text" name="mem_email" value="${vo.mem_email }"></td>
		</tr>
		<tr>
			<th>주소</th><td><input type="text" name="mem_addr" value="${vo.mem_addr }"></td>
		</tr>
		<tr>
			<td><input type="submit" value="저장"></td>
		</tr>
		<tr>
			<td><a href="${cp }/mem/memDelete.jsp">회원탈퇴</a></td>
		</tr>
	</table>
</form>
<p><a href="${cp }/mypage/home">MYPAGE 목록</a>
</div>
