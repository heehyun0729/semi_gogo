<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id = "board">
	<h1>ORDER</h1>
	<h3>주문서작성</h3>
	<br>
	<h3>주문내역</h3>
	<table border = "1" style="width: 700px;">
			<tr>
				<th>이미지</th>
				<th>상품정보</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
			</tr>
			<c:set var = "i" value = "1"/>
			<c:forEach var = "vo" items = "${list }">
				<tr>
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
				</tr>
				<c:set var = "sum" value = "${sum + vo.tot}"/>
				<c:set var = "i" value = "${i + 1 }"/>
			</c:forEach>
			<tr>
				<td colspan = "8">합계: ${sum }원</td>
			</tr>
		</table>
		<br>
		<h3>배송정보</h3>
		<form method="post" action="${cp }/order/payInsert">
			<table border = "1" style="width: 500px;">
				<tr>
					<td>배송지 선택</td>
					<td>
						<input type = "radio" id = "same" value = "same" checked="checked">회원 정보와 동일
						<input type = "radio" id = "new" value = "new">새로운 배송지
					</td>
				</tr>
				<tr>
					<td>받으시는 분<img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></td>
					<td><input type = "text" id = "name" name = "name" value = ""></td>
				</tr>
				<tr>
					<td>주소 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></td>
					<td><textarea rows="3" cols="50" name="addr" id = "addr"></textarea></td>
				</tr>
				<tr>
					<td>전화번호<img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></td>
					<td>
						<select name="phone" id="phone" size="1">
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="070">070</option>
							<option value="010">010</option>
							<option value="011">011</option>
						</select>
						<input type="text" name="phonetext" id = "phonetext">(- 없이 입력)
					</td>
				</tr>
				<tr>
					<td>이메일 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></td>
					<td><input type="text" name="email" id = "email" value = ""></td>
				</tr>
				<tr>
					<td>배송메시지</td>
					<td><textarea rows="3" cols="50" name="addr" id = "addr"></textarea></td>
				</tr>
			</table>
			<br>
			<h3>결제예정금액</h3>
			<h4>${sum }원</h4>
			<br>
			<h3>결제수단</h3>
			<table border = "1" style="width: 500px;">
				<tr>
					<td colspan = "2">
						<input type = "radio" id = "noaccount" checked="checked">무통장입금
						<input type = "radio" id = "account">계좌이체
						<input type = "radio" id = "card">카드결제
						<input type = "radio" id = "phonepay">휴대폰 결제
					</td>
				</tr>
				<tr>
					<td>
						<table border = "1" style="width: 300px;">
							<tr>
								<td>입금자명</td>
								<td><input type = "text" id = "payname"></td>
							</tr>
						</table>
						<table border = "1" style="width: 300px;position: none;">
							<tr>
								<td>예금주명</td>
								<td><input type = "text" id = "accountname"></td>
							</tr>
						</table>
						<div id = "paymsg" style="position: none;">소액 결제의 경우 PG사 정책에 따라 결제 금액 제한이 있을 수 있습니다.</div>
					</td>
				</tr>
			</table>
			<div>
				최종결제금액
				<h4>${sum }원</h4>
				<input type = "submit" value = "결제하기">
			</div>
		</form>
</div>