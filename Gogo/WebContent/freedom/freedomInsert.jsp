<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board">
	<div>
    	<h1>freedom</h1>
    </div>
    <hr>
 	<div>
 		<form method="post" action="<%=request.getContextPath() %>/freedom/freedomInsert.do" enctype="multipart/form-data">
 			<table border="1" style="width:500px;">
 				<tr>
 					<td>제목</td>
 					<td><input type="text" name="freedom_title"></td>
 				</tr>
 				<tr>
 					<td colspan="2">내용<textarea rows="10" cols="80" name="freedom_content"></textarea></td>
 				</tr>
 				<tr>
 					<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="취소" onclick="javascript:history.go(-1)">
					</td>
				</tr>			
 			</table> 
 		</form>
 	</div>
</div>
<!--  --> 		