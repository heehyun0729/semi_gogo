<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>Wish List</h1>
	<h3>관심상품</h3>
	<form method="post" action="${cp }/mypage/interDelete.do?select=ck">
		<table border = "1" style="width: 500px;">
			<tr>
				<th><input type = "checkbox" id = "ckAll" onclick="checkAll()"></th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
			<c:forEach var = "vo" items = "${list }">
				<tr>
					<td><input type = "checkbox" name = "check" value = "${vo.inter_num }" onclick="isChecked()"></td>
					<td>
						<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
							<img src = "${cp }/upload/product/${vo.img_saveImg}" style="width: 100px; height: 100px;">
						</a>
					</td>
					<td>
						<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
							${vo.prod_name }
						</a>
					</td>
					<td>${vo.price }원</td>
					<td>
						<a href = "${cp }/mypage/interDelete.do?select=one&inter_num=${vo.inter_num}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "선택상품삭제"><br>
		<a href = "${cp }/mypage/interDelete.do?select=all">관심상품 비우기</a><br>
		<a href = "javascript:history.go(-1)">쇼핑계속하기</a>
	</form>
</div>