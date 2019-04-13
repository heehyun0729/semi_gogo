<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>ORDER</h1>
	<h3>주문내역</h3>
	<div id = "search">
		<form method="post" action="${cp }/mypage/orderList">
			기간별 조회 (yyyy-mm-dd)
			<input type = "text" name = "startDate" value = "${startDate }"> ~
			<input type = "text" name = "endDate" value = "${endDate }">
			<input type = "submit" value = "조회">
		</form>
	</div>
	<table border = "1" style="width: 700px;">
		<tr>
			<th>주문일자<br>[주문번호]</th>
			<th>이미지</th>
			<th>상품정보</th>
			<th>수량</th>
			<th>구매금액</th>
			<th>주문처리상태</th>
		</tr>
		<c:set var = "i" value = "0"/>
		<c:forEach var = "vo" items = "${list }">
		<c:set var = "prevNum" value = "${vo.buy_num }"/>
			<tr>
			<c:if test="${i == 0 }">
				<td rowspan="${vo.length }">
					${vo.buy_bdate }<br>
					[${vo.buy_num}]
				</td>
			</c:if>
				<td>
					<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
						<img src = "${cp }/upload/product/${vo.img_saveImg}" style="width: 100px; height: 100px;">
					</a>
				</td>
				<td>
					<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
						${vo.prod_name }<br>
					</a>
					<c:if test="${vo.op_name != vo.prod_name }">
						<div id = "op">[옵션: ${vo.op_name } - ${vo.detailOp_name } (+${vo.detailOp_price })]</div>
					</c:if>
				</td>
				<td>${vo.cnt }</td>
				<td>${vo.tot }원</td>
				<td>
					결제완료<br>
					<a href = "">구매후기</a>
				</td>
			</tr>
			<c:set var = "i" value = "${i + 1 }"/>
			<c:if test="${i == vo.length }">
				<c:set var = "i" value = "0"/>
			</c:if>
		</c:forEach>
	</table>
	<div id = "pages">
		<c:choose>
			<c:when test="${startPage > 10 }">
				<a href = "${cp }/mypage/orderList?pageNum=${startPage - 1}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
			<c:choose>
				<c:when test="${pageNum == i }">
					<a href = "${cp }/mypage/orderList?pageNum=${i}"><span style = "color: pink;">[${i }]</span></a>
				</c:when>
				<c:otherwise>
					<a href = "${cp }/mypage/orderList?pageNum=${i}"><span style = "color: gray;">[${i }]</span></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPage < pageCnt }">
				<a href = "${cp }/mypage/orderList?pageNum=${endPage + 1}">▶</a>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>
	</div>
</div>