<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>REVIEW</h1>
	<h3>후기</h3>
	<div id = "search">
		<form method="post" action="${cp }/board/review?menu_num=${menu_num}">
			상품명
			<input type = "text" name = "keyword" value = "${keyword }">
			<input type = "submit" value = "조회">
		</form>
	</div>
	<a href = "${cp }/board/reviewInsert?menu_num=11">글쓰기</a>
	<table border = "1" style = "width: 700px;">
		<tr>
			<th>상품사진</th><th>상품명</th><th>작성자</th><th>제목</th>
			<th>별점</th><th>추천수</th><th>작성일</th>
		</tr>
		<c:forEach var = "vo" items = "${list }">
			<tr>
				<td>
					<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
						<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px;height: 100px;">
					</a>
				</td>
				<td>
					<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">${vo.prod_name }</a>
					<c:if test="${vo.prod_name != vo.op_name }">
						[옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
					</c:if>
				</td>
				<td><a href = "${cp }/board/reviewDetail?review_num=${vo.review_num}">${vo.review_title }</a></td>
				<td>${vo.mem_id }</td>
				<td>${vo.review_star }</td>
				<td>${vo.review_like }</td>
				<td>${vo.review_wdate }</td>
			</tr>
		</c:forEach>
	</table>
	<div id = "pages">
		<c:choose>
			<c:when test="${startPage > 10 }">
				<a href = "${cp }/board/review?pageNum=${startPage - 1}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
			<c:choose>
				<c:when test="${pageNum == i }">
					<a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${i}"><span style = "color: pink;">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${i}"><span style = "color: gray;">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPage < pageCnt }">
				<a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${endPage + 1}">▶</a>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>
	</div>
</div>