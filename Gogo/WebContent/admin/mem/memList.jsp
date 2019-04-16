<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content_wrap" style="padding-top: 5%; padding-bottom: 5%">
<div id="box" style="width: 40%; height: 50%; margin: auto;">
<h3>GOGO's Member List</h3>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">회원이름</th>
      <th scope="col">연락처</th>
      <th scope="col">Email</th>
      <th scope="col">주소</th>
      <th scope="col">회원상태</th>
      <th scope="col">정보관리</th>
    </tr>
  </thead>
  	<c:forEach var="vo" items="${requestScope.list }">
  <tbody>
   <tr>
				<td>${vo.mem_id }</td>
				<td>${vo.mem_name }</td>
				<td>${vo.mem_phone }</td>
				<td>${vo.mem_email }</td>
				<td>${vo.mem_addr }</td>
				<td>${vo.mem_stat }</td>
				<td><a href="${pageContext.request.contextPath }/admin/memsUpdate.do?mem_id=${vo.mem_id}">수정</a></td>
			</tr>
		</c:forEach>
  </tbody>
</table>
<div id="memPageNum" style="text-align:center;">
	<c:choose>
		<c:when test="${startPage>4 }">
			<a href="${cp }/admin/mem/memList?pageNum=${startPage-1}">◀</a>
		</c:when>
		<c:otherwise>
			◁
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/admin/mem/memList?pageNum=${i }"><span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/admin/mem/memList?pageNum=${i }"><span style='color:#847D76'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="${cp }/admin/mem/memList?pageNum=${endPage+1 }">▶</a>
		</c:when>
		<c:otherwise>
			▷
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>