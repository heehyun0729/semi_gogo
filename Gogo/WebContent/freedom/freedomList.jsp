<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
 <div id="board">
	<div id="title">
		<h1>자유게시판</h1>
	</div>
	
	<div>
  		<input type="button" value="글쓰기" onclick="location.href='${pageContext.request.contextPath}/freedom/freedomInsert.do' ">
  		<input type="button" value="목록"  onclick="Locateion.href='${cp}/freedom/freedomDetail.do?menu_num=${menu_num}&freedom_num=${vo.freedom_num}'">
  	</div>
  <div id="freedomList">	
<table border="1">
	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>날짜</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.freedom_num }</td>
			<td><a href="${pageContext.request.contextPath }/freedom/freedomDetail.do?freedom_num=${vo.freedom_num}&field=${field}&keyword=${keyword}&pageNum=${pageNum}">${vo.freedom_title }</a></td>
			<td>${vo.freedom_content }</td>
			<td>${vo.freedom_wdate }
			<td>${vo.freedom_hit }</td>
			
			
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
	
	<div id="freedomFind">
		<form method="post" action="${cp }/freedom/freedomList.do">
			<select name="field">
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
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>	
	 </div>
</div>
