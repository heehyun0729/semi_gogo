<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%--
 <div id="board">
	<ol class="breadcrumb">
		  <li><a href="${cp }/admin/home">Home</a></li>
		  <li><a href="#">/</a></li>
		  <li class="active">List</li>
</ol>
	--%> 
	
	<meta charset="UTF-8">
	<div class="bg-light py-3">
		<div class="container">
			<div class="col-md-12 mb-0">
				<a href="${cp }/admin/home">Home</a>
				<sapn calss="mx-2 mb-0">/</sapn>
				<strrong class="text-black">List</strrong>
			</div>
		</div>
	</div>			
	
	
	
	<div>
  		<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='${pageContext.request.contextPath}/freedom/freedomInsert.do' " style="float: right;margin-bottom: 20px;margin-left: 5px;">
  		<input class="btn btn-primary" type="button" value="목록"  onclick="location.href='${cp}/freedom/freedomList.do?menu_num=${menu_num}&freedom_num=${vo.freedom_num}'" style="float: right;margin-bottom: 20px;margin-left: 5px;">
  	</div>
  <div id="freedomList">	
<table class="table table-hover" style="text-align:center">
	<tr>
		<td class="text-cneter">글번호</td>
		<td class="text-cneter">제목</td>
		<td class="text-cneter">내용</td>
		<td class="text-cneter">날짜</td>
		<td class="text-cneter">조회수</td>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td><strong><a class="text-primary" href = "${vo.freedom_num }</a></strong></td>
			<td><a href="${pageContext.request.contextPath }/freedom/freedomDetail.do?freedom_num=${vo.freedom_num}&field=${field}&keyword=${keyword}&pageNum=${pageNum}">${vo.freedom_title }</a></td>
			<td><strong><a class="text-black">${vo.freedom_content }</a></strong></td>
			<td><strong><a class="text-black">${vo.freedom_wdate }</a></strong></td>
			<td><strong><a class="text-black">${vo.freedom_hit }</a></strong></td>
			
			
		</tr>
	</c:forEach>
</table>
</div>
	<div id="freedomPageNum">
		<c:choose>
			<c:when test="${startPage>10 }">
				<a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${startPage-1 }">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		<c:forEach var = "i" begin="${startPage }" end ="${endPage }">
			<c:choose>
				<c:when test="${i==pageNum }">
					<a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${i}"><span style='color:blue'>[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${i}"><span style='color:#999'>[${i }]</span></a>
				</c:otherwise>
		</c:choose>	
		</c:forEach>
		<c:choose>
			<c:when test="${endPage < pageCount }">
				<a href="${pageContext.request.contextPath }/freedom/freedomList.do?pageNum=${endPage+1 }">▶</a>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>	
	</div>
	
	<div class="row text-center" style="width: 100%">
		<div style="width: 50%; float:none; margin:0 auto">
			<div id="freedomFind">
				<form method="post" action="${cp }/freedom/freedomList.do">
					<select name="field" class="form-control col-sm-3" style="display: inline-block;">
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
