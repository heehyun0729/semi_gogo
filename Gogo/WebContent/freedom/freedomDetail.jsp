<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light py-3">
	<div class="container">
		<div class="col-md-12 mb-0">
			<a href="${cp }/home">Home</a>
			<span class="mx-2 mb-0">/</span>
			<strong class="text-black">Deteail</strong>
			<span class="mx-2 mb-0">/</span>
			<strong class="text-black">상세보기</strong>
		</div>
	</div>
</div>			


<div id="board">
	<div>
		<div class="col-md-12 mb-5">
        	<div class="float-md-left mb-4" style="margin-left:25%"><h2 class="text-black h5">Detail</h2></div>
      	</div>
		<div>
		<table class="table table-hover" style="width: 52%; margin-top: 3rem; margin-left: 25%; text-align:center">
			<tr>
				<td class="text-cneter">작성번호</td>
				<td>${vo.freedom_num } 
			</tr>
			<tr>
				<td class="text-cneter">제목</td>
				<td>${vo.freedom_title }</td>
			</tr>
			<tr>
				<td class="text-cneter">내용</td>
				<td><textarea cols="50" rows="5" disabled="disabled">${vo.freedom_content }</textarea></td>
			</tr>
			<tr>
				<td class="text-cneter">작성일</td>
				<td>${vo.freedom_wdate }</td>
			</tr>
			<tr>
				<td class="text-cneter">조회수</td>
				<td>${vo.freedom_hit }</td>
			</tr>		
		</table>
				<div class="row text-center" style="width: 100%">
					<div style=" float:none; margin-left:51%" >
				<input class="btn btn-primary" type="button" value="목록" onclick="location.href='${cp }/freedom/freedomList.do'">
				<input class="btn btn-primary" type="button" value="수정" onclick="location.href='${cp }/freedom/freedomUpdate.do?freedom_num=${vo.freedom_num}'">
				<input class="btn btn-primary" type="button" value="삭제" onclick="location.href='${cp }/freedom/freedomDelete.do?freedom_num=${vo.freedom_num}'">
					</div>
				</div>
		</div>
	</div>
</div>		