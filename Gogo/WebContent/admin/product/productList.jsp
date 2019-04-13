<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>상품목록</h1>
	<select name = "menu" onchange="changeMenu(this.value, '${cp }')">
		<option value = ""
			<c:if test = "${menu_num == '0'}">
				selected = "selected"
			</c:if>
		>CLOTHING</option>
		<option value = "1"
			<c:if test = "${menu_num == '1'}">
				selected = "selected"
			</c:if>
		>사료</option>
		<option value = "2"
			<c:if test = "${menu_num == '2'}">
				selected = "selected"
			</c:if>
		>간식</option>
		<option value = "3"
			<c:if test = "${menu_num == '3'}">
				selected = "selected"
			</c:if>
		>낚싯대</option>
		<option value = "4"
			<c:if test = "${menu_num == '4'}">
				selected = "selected"
			</c:if>
		>터널</option>
		<option value = "5"
			<c:if test = "${menu_num == '5'}">
				selected = "selected"
			</c:if>
		>인형</option>
		<option value = "6"
			<c:if test = "${menu_num == '6'}">
				selected = "selected"
			</c:if>
		>모래</option>
		<option value = "7"
			<c:if test = "${menu_num == '7'}">
				selected = "selected"
			</c:if>
		>정수기</option>
		<option value = "8"
			<c:if test = "${menu_num == '8'}">
				selected = "selected"
			</c:if>
		>스크래쳐</option>
	</select>
	<p><a href = "${cp }/admin/product/productInsert">상품등록</a></p>
	<c:forEach var = "vo" items = "${list }">
		<div style="display: inline-block; float: left;">
			<a href = "${cp }/product/productDetail.do?menu_num=${menu_num }&prod_num=${vo.prod_num}">
				<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px; height: 100px;"><br>
				${vo.prod_name}<br>
				${vo.prod_price }
			</a>
		</div>
	</c:forEach>	
	<div id = "pages" style = "clear: both;">
		<c:choose>
			<c:when test="${startPage > 4 }">
				<a href = "${cp }/product/productList.do?pageNum=${startPage - 1}&menu_num=${menu_num }">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
			<c:choose>
				<c:when test="${pageNum == i }">
					<a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }"><span style = "color: pink;">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }"><span style = "color: gray;">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPage < pageCnt }">
				<a href = "${cp }/product/productList.do?pageNum=${endPage + 1}&menu_num=${menu_num }">▶</a>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>
	</div>
</div>