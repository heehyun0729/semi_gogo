<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="board">
 	<div>
   <h1>게시글 수정하기</h1>
	</div>
 	<form method="post" action="${cp }/freedom/freedomUpdate.do">
 		<input type="hidden" name="freedom_num" value="${vo.freedom_num }">
 		
 		<table border = "1" style="width: 500px;">
 	
 			<tr>
 				<td>제목</td>
 				<td><input type="text" name="freedom_title" value="${vo.freedom_title }"></td>
 			</tr>
 			<tr>
 				<td>내용</td>
 				<td colspan="2">내용<textarea rows="10" cols="80" name="freedom_content">${vo.freedom_content }</textarea></td>
 			
			<tr>	
			<td colspan = "2">
					<input type = "submit" value = "수정">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
 		</table>
 	</form>	
 </div>  