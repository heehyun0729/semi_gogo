<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board">
	<div id="title">
		<h1>Notice | 공지사항</h1>
	</div>
	
	<div>
		<input type="button" value="글쓰기" onclick="location.href='${pageContext.request.contextPath }/board/noticeInsert.do' ">
		<input type="button" value="목록" onclick="location.href='${cp }/board/noticeList.do?menu_num=${menu_num}&notice_num=${nvo.notice_num }'">
	</div>
	<form name="cate" method="post">
	<select onchange="getCate(this.value)"> 
		<option value="">전체</option>
		<option value="0"
			<c:if test = "${cate == '0'}">
				selected = "selected"
			</c:if>
		>공지사항</option>
		<option value="1"
			<c:if test = "${cate == '1'}">
				selected = "selected"
			</c:if>
		>이벤트</option>
	</select>
	</form>
	<script type="text/javascript">
		function getCate(value){
			location.href="${pageContext.request.contextPath }/board/noticeList.do?cate=" + value;
		}
	</script>
	
	<div id="noticeList">
		<table border="1">
		<tr>
			<td>번호</td>
			<td>카테고리</td>
			<td>제목</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="vo" items="${list }">
			<c:choose>
				<c:when test="${vo.notice_step==0 }">
					<tr>
						<td><b>${vo.notice_num }</b></td>
						<c:choose>
							<c:when test="${vo.notice_cate==0 }">
								<td><b>공지사항</b></td>
							</c:when>
							<c:when test="${vo.notice_cate==1 }">
								<td><b>이벤트</b></td>
							</c:when>
						</c:choose>
						<td><b><a href = "${pageContext.request.contextPath }/board/noticeDetail.do?menu_num=${param.menu_num}&notice_num=${vo.notice_num}">${vo.notice_title }</a></b></td>
						<td><b>${vo.notice_hit }</b></td>
					</tr>
				</c:when>
				<c:when test="${vo.notice_step==1 }">
					<tr>
						<td>${vo.notice_num }</td>
						<c:choose>
							<c:when test="${vo.notice_cate==0 }">
								<td>공지사항</td>
							</c:when>
							<c:when test="${vo.notice_cate==1 }">
								<td>이벤트</td>
							</c:when>
						</c:choose>
						<td><a href = "${pageContext.request.contextPath }/board/noticeDetail.do?menu_num=${param.menu_num}&notice_num=${vo.notice_num}">${vo.notice_title }</a></td>
						<td>${vo.notice_hit }</td>
					</tr>
				</c:when>
			</c:choose>
		</c:forEach>
	</table>
	<br>
	</div>
	
	<div id="noticePageNum">
	<c:choose>
		<c:when test="${startPage>10 }">
			<a href="${pageContext.request.contextPath }/board/noticeList.do?pageNum=${startPage-1 }">◀</a>
		</c:when>
		<c:otherwise>
			◁
		</c:otherwise>
	</c:choose>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:choose>
				<c:when test="${i==pageNum }">
					<a href="${pageContext.request.contextPath }/board/noticeList.do?pageNum=${i}"><span style='color:blue'>[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/board/noticeList.do?pageNum=${i}"><span style='color:#999'>[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	<c:choose>
		<c:when test="${endPage<pageCount}">
			<a href="${pageContext.request.contextPath }/board/noticeList.do?pageNum=${endPage+1 }">▶</a>
		</c:when>
		<c:otherwise>
			▷
		</c:otherwise>
	</c:choose>
	</div>
	
	<div id="noticeFind">
		<form method="post" action="${cp }/board/noticeList.do">
			<select name="field">
				<option value="notice_all">제목+내용</option>
			  	<option value="notice_title"
					<c:if test="${field=='notice_title' }">
						selected='selected'
					</c:if>
					>제목</option>
				<option value="notice_content"
					<c:if test="${field=='notice_content' }">
						selected='selected'
					</c:if>
					>내용</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>	
	</div>
</div>