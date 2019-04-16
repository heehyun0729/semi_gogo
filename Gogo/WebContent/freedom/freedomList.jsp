<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light py-3">
	<div class="container">
		<div class="col-md-12 mb-0">
			<a href="${cp }/admin/home">Home</a>
			<span class="mx-2 mb-0">/</span>
			<strong class="text-black">List</strong>
		</div>
	</div>
</div>			
	
	
	
<div>
	<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='${pageContext.request.contextPath}/freedom/freedomInsert.do' " style="float: right;margin-bottom: 20px;margin-left: 5px;margin-right: 15%;">
	<input class="btn btn-primary" type="button" value="목록"  onclick="location.href='${cp}/freedom/freedomList.do?menu_num=${menu_num}&freedom_num=${vo.freedom_num}'" style="float: right;margin-bottom: 20px;margin-left: 5px;">
</div>

<div>
	<table class="table table-hover" style="width: 70%; margin-top: 3rem; margin-left: 15%; text-align:center">
		<tr>
			<td class="text-cneter">글번호</td>
			<td class="text-cneter">제목</td>
			<td class="text-cneter">내용</td>
			<td class="text-cneter">날짜</td>
			<td class="text-cneter">조회수</td>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.freedom_num }</td>
				<td><a href="${pageContext.request.contextPath }/freedom/freedomDetail.do?freedom_num=${vo.freedom_num}&field=${field}&keyword=${keyword}&pageNum=${pageNum}">${vo.freedom_title }</a></td>
				<td class="text-black">${vo.freedom_content }</td>
				<td class="text-black">${vo.freedom_wdate }</td>
				<td class="text-black">${vo.freedom_hit }</td>
			</tr>
		</c:forEach>
	</table>
</div>

<c:choose>
<c:when test="${startPage!=null}">
<div class="row text-center" style="width: 100%;margin-top:50px;" data-aos="fade-up">
	 <div class="col-md-12 text-center">
	         <div class="site-block-27">
	         	<ul>
	<c:choose>
		<c:when test="${startPage>10 }">
			<li><a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${startPage-1 }">&lt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a>&lt;</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var = "i" begin="${startPage }" end ="${endPage }">
		<c:choose>
			<c:when test="${pageNum == i }">
				<li><a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${i}">[${i }]</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${i}">[${i }]</a></li>
			</c:otherwise>
	</c:choose>	
	</c:forEach>
	<c:choose>
		<c:when test="${endPage < pageCount }">
			<li><a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${endPage+1 }">&gt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a>&gt;</a></li>
		</c:otherwise>
	</c:choose>
		</ul>
	</div>
	</div>
</div>
</c:when>
</c:choose>	


<div class="row text-center" style="width: 100%">
	<div style="width: 50%; float:none; margin:0 auto">
		<div id="freedomFind">
			<form method="post" action="${cp }/freedom/freedomList.do">
				<select name="field" class="form-control col-sm-3" style="display: inline-block;width: 80px;">
					<option value="freedom_title"
						<c:if test="${field=='freedom_title' }">
							selected='selected'
						</c:if>
						>제목</option>	
					<option value="freedom_content"
						<c:if test="${field=='freedom_content' }">
							selected='selected'
						</c:if>	
						>내용</option>
				</select>
		
				<input type="text" name="keyword" class="form-control col-sm-5" style="display: inline-block;">
				<input type="submit" value="검색" class="btn btn-primary">
			</form>	
	 	</div>
	 </div>
</div>
<!--  -->