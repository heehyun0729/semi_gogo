<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<h1>상품등록</h1>
	<form method="post" action="${cp }/admin/product/productInsert" 
		enctype="multipart/form-data" onsubmit = "return prodValidate();">
		<table border = "1" style="width: 500px;">
			<tr>
				<td>카테고리</td>
				<td>
					<select name = "cate" onchange="getMenu(this.value, '${cp }')">
						<option value = "">- [필수]선택 -</option>
						<option value = "0">CLOTHING</option>
						<option value = "1">FOOD</option>
						<option value = "2">TOY</option>
						<option value = "3">ETC</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td>
					<select name = "menu"></select>
				</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type = "text" name = "price"></td>
			</tr>
			<tr>
				<td>옵션</td>
				<td>
					<input type = "button" value = "옵션추가" id = "btnAdd" onclick="addDivOp()">
					<div id = "op">
					</div>
				</td>
			</tr>
			<tr>
				<td>썸네일이미지</td>
				<td><input type = "file" name = "img"></td>
			</tr>
			<tr>
				<td rowspan = "3">상품이미지</td>
				<td><input type = "file" name = "pimg1"></td>
			</tr>
			<tr>
				<td><input type = "file" name = "pimg2"></td>
			</tr>
			<tr>
				<td><input type = "file" name = "pimg3"></td>
			</tr>
			<tr>
				<td rowspan = "3">상세설명이미지</td>
				<td><input type = "file" name = "dimg1"></td>
			</tr>
			<tr>
				<td><input type = "file" name = "dimg2"></td>
			</tr>
			<tr>
				<td><input type = "file" name = "dimg3"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<div id = "msg" style = "color: red; font-size: 12px;"></div>
					<input type = "submit" value = "등록">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>