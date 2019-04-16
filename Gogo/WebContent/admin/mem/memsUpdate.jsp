<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
<h1>회원정보</h1>
	<form method="post" action="${cp }/memsUpdate.do">
	<table>
		<tr>
			<th>아이디</th><td><input type="text" name="mem_id" value=${vo.mem_id }></td>
		</tr>
		<tr>
			<th>이름</th><td><input type="text" name="mem_name" value=${vo.mem_name }></td>
		</tr>
		<tr>
			<th>연락처</th><td><input type="text" name="mem_phone" value=${vo.mem_phone }></td>
		</tr>
		<tr>
			<th>Email</th><td><input type="text" name="mem_email" value=${vo.mem_email }></td>
		</tr>
		<tr>
			<th>주소</th><td><input type="text" name="mem_addr" value=${vo.mem_addr }></td>
		</tr>
	</table>
	</form>
</div>
