<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>BASKET</h1>
	<h3>장바구니</h3>
	<form method="post">
		<table border = "1" style="width: 700px;">
			<tr>
				<th><input type = "checkbox" id = "ckAll" onclick="checkAll()"></th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
				<th>선택</th>
			</tr>
			<c:set var = "i" value = "1"/>
			<c:forEach var = "vo" items = "${list }">
				<tr>
					<td><input type = "checkbox" name = "check" value = "${vo.basket_num }" onclick="isChecked()"></td>
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
					<td>${vo.price }원</td>
					<td>
						<input type="button" value="▲" onclick="basketCntUp('cnt${i}')">
						<input type="text" id="cnt${i }" value="${vo.cnt }" readonly="readonly" style="width: 20px;">
						<input type="button" value="▼" onclick="basketCntDown('cnt${i}')"><br>
						<input type = "button" value = "수정" onclick="changeCnt('${cp}', 'cnt${i}','${vo.basket_num }')">
					</td>
					<td>${vo.tot }원</td>
					<td>
						<a href = "${cp }/mypage/interInsert.do?prod_num=${vo.prod_num }">관심상품등록</a><br>
						<a href = "${cp }/order/basketDelete.do?select=one&basket_num=${vo.basket_num}">삭제</a>
					</td>
				</tr>
				<c:set var = "sum" value = "${sum + vo.tot}"/>
				<c:set var = "i" value = "${i + 1 }"/>
			</c:forEach>
			<tr>
				<td colspan = "8">합계: ${sum }원</td>
			</tr>
		</table>
		<input type = "submit" value = "선택상품삭제" onclick="javascript: form.action='${cp }/order/basketDelete.do?select=ck'"><br>
		<input type = "submit" value = "전체상품주문" onclick="javascript: form.action='${cp }/order/buyInsert?select=all'"><br>
		<input type = "submit" value = "선택상품주문" onclick="javascript: form.action='${cp }/order/buyInsert?select=ck'"><br>
		<a href = "${cp }/order/basketDelete.do?select=all">장바구니 비우기</a><br>
		<a href = "javascript:history.go(-1)">쇼핑계속하기</a>
	</form>
</div>