<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>My Board</h1>
	<h3>게시물관리</h3>
	<br>
	<h3>Q&A | 문의</h3>
	<select name = "cate" onchange="getQnaList(this.value)">
		<option value = "">전체</option>
		<option value = "prod"
			<c:if test = "${cate == 'prod'}">
				selected = "selected"
			</c:if>
		>상품</option>
		<option value = "ship"
			<c:if test = "${cate == 'ship'}">
				selected = "selected"
			</c:if>
		>배송</option>
		<option value = "cancel"
		
			<c:if test = "${cate == 'cancel'}">
				selected = "selected"
			</c:if>
		>교환/반품</option>
		<option value = "pay"
			<c:if test = "${cate == 'pay'}">
				selected = "selected"
			</c:if>
		>결제</option>
		<option value = "etc"
			<c:if test = "${cate == 'etc'}">
				selected = "selected"
			</c:if>
		>기타</option>
	</select>
	<script type="text/javascript">
		function getQnaList(value) {
			location.href = "${cp}/mypage/myboard?menu_num=10&cate=" + value + "&field=${field}&keyword=${keyword}";
		}
	</script>
	<a href = "${cp }/board/qnaInsert?menu_num=${param.menu_num}">글쓰기</a>
	<table border = "1" style="width: 500px;">
		<tr>
			<th>번호</th><th>카테고리</th><th>제목</th><th>작성자</th><th>작성일</th>
		</tr>
		<c:forEach var = "vo" items = "${list }">
			<tr>
				<td>${vo.qna_num }</td>
				<td>
					<c:choose>
						<c:when test="${vo.qna_cate == 'prod' }">
							상품
						</c:when>
						<c:when test="${vo.qna_cate == 'ship' }">
							배송
						</c:when>
						<c:when test="${vo.qna_cate == 'cancel' }">
							교환/반품
						</c:when>
						<c:when test="${vo.qna_cate == 'pay' }">
							결제
						</c:when>
						<c:when test="${vo.qna_cate == 'etc' }">
							기타
						</c:when>
					</c:choose>
				</td>
				<td>
					<c:if test="${vo.qna_level > 0 }">
						<c:forEach var = "i" begin = "1" end = "${vo.qna_level }">
							&nbsp;&nbsp;
						</c:forEach>
						[re]
					</c:if>
					<a href = "${cp }/board/qnaDetail?menu_num=${param.menu_num}&qna_num=${vo.qna_num}">${vo.qna_title }</a>
				</td>
				<td>${vo.mem_id }</td>
				<td>${vo.qna_wdate }</td>
			</tr>
		</c:forEach>
	</table>
	<div id = "pages">
		<c:choose>
			<c:when test="${startPage > 10 }">
				<a href = "${cp }/mypage/myboard?menu_num=${param.menu_num}&pageNum=${startPage - 1}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
			<c:choose>
				<c:when test="${pageNum == i }">
					<a href = "${cp }/mypage/myboard?menu_num=${param.menu_num}&pageNum=${i}"><span style = "color: pink;">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href = "${cp }/mypage/myboard?menu_num=${param.menu_num}&pageNum=${i}"><span style = "color: gray;">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPage < pageCnt }">
				<a href = "${cp }/mypage/myboard?menu_num=${param.menu_num}&pageNum=${endPage + 1}">▶</a>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>
	</div>
	<div id = "search">
		<form method="post" action="${cp }/mypage/myboard?menu_num=${param.menu_num}">
			<select name = "field">
				<option value = "all"
					<c:if test = "${field == 'all' }">
						selected = "selected"
					</c:if>
				>제목+내용</option>
				<option value = "qna_title"
					<c:if test = "${field == 'qna_title' }">
						selected = "selected"
					</c:if>
				>제목</option>
				<option value = "qna_content"
					<c:if test = "${field == 'qna_content' }">
						selected = "selected"
					</c:if>
				>내용</option>
				<option value = "mem_id"
					<c:if test = "${field == 'mem_id' }">
						selected = "selected"
					</c:if>
				>작성자</option>
			</select>
			<input type = "text" name = "keyword" value = "${keyword }">
			<input type = "submit" value = "검색">
		</form>
	</div>
</div>