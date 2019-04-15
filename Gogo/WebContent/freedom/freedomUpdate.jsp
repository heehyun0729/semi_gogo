<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="board">
 	<div>
   <h1>게시글 수정하기</h1>
	</div>
 	<form method="post" action="${cp }/freedom/freedomUpdate.do" enctype="multipart/form-data">
 		<input type="hidden" name="freedom_num" value="${freedom_num }" disabled="disabled">
 		<input type="hidden" name="freedom_title" value="${freedom_title }">
 		<input type="hidden" name="freedom_content" value="${freedom_content }">
 		<input type="hidden" name="freedom_wdate" value="${freedom_wdate }" disabled="disabled">
 		<input type="hidden" name="freedom_hit" value="${freedom_hit }" disabled="disabled">
 		<table border = "1" style="width: 500px;">
 	
 			<tr>
 				<td>제목</td>
 				<td><input type="text" name="freedom_title" value="${vo.freedom.title }"></td>
 			</tr>
 			<tr>
 				<td>내용</td>
 				<td colspan="2">내용<textarea rows="10" cols="80" name="freedom_content"></textarea></td>
 			</tr>
 			<tr>
				<td>첨부파일1</td>
				<td><input type = "file" name = "file1"></td>
			</tr>
			<tr>
				<td>첨부파일2</td>
				<td><input type = "file" name = "file2"></td>
			</tr>
			<tr>	
			<td colspan = "2">
					<input type = "submit" value = "수정">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
 		</table>
 	</form>	
 </div>  