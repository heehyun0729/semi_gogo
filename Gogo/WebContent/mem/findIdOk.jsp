<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
<table>
<th>해당 아이디정보</th>
<tr>
	<td><input type="text" name="mem_id" value="${vo.mem_id }"></td>
</tr>
<tr>
	<td><a href="${cp }/mem/login">로그인하기</a></td>
</tr>
</table>
</div>