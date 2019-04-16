<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="bg-light py-3">
	<div class="container">
		<div class="col-md-12 mb-0">
			<a href="${cp }/home">Home</a>
			<span class="mx-2 mb-0">/</span>
			<strong class="text-black">Update</strong>
			<span class="mx-2 mb-0">/</span>
			<strong class="text-black">글수정</strong>
		</div>
	</div>
</div>			
 
 <div id="board">
 	<div class="col-md-12 mb-5">
        <div class="float-md-left mb-4" style="margin-left:25%"><h2 class="text-black h5">Update</h2></div>
     </div>
 	<form method="post" action="${cp }/freedom/freedomUpdate.do">
 		<input type="hidden" name="freedom_num" value="${vo.freedom_num }">
 		
 		<table class="table table-hover" style="width: 52%; margin-top: 3rem; margin-left: 25%; text-align:center">
 	
 			<tr>
 				<td class="text-cneter">제목</td>
 				<td class="text-black"><input style="width: 50%" type="text" name="freedom_title" value="${vo.freedom_title }"></td>
 			</tr>
 			<tr>
 				<td class="text-cneter">내용</td>
 				<td class="text-cneter" colspan="2"><textarea rows="10" cols="80" name="freedom_content">${vo.freedom_content }</textarea></td>
			<tr>	
			</table>
					<div class="row text-center" style="width: 100%">
						<div style=" float:none; margin-left:51%" >
							<input type = "submit" value = "수정">
							<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
 						</div>
 					</div>	
 	</form>	
 </div>  