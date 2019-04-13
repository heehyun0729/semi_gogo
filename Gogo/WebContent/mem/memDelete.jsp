<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<form method="post" action="${cp }/mem/delete.do">
		<h1>회원탈퇴</h1>
		<h3>비밀번호 입력</h3>
	<!-- <input type="hidden" id="mem_id" value="${vo.mem_id}"> -->	
		password <input type="password" name="mem_pwd"> <input type="submit" value="탈퇴"> 
	</form>
</div>