<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">PRODUCT</strong>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">상품수정</strong>
       </div>
     </div>
   </div>
</div>

<div class="site-section">
	<div class="container">
		<div class="row" >
			<!-- 해당 사이트 제목 -->
				<div class="col-md-12 mb-6">
	               <div class="float-md-left mb-4"><h2 class="text-black h5">상품수정</h2></div>
	            </div>
			<!--// 해당 사이트 제목 -->
			<div style="width: 70%;margin-left: 15%;margin-right: 15%;">
				<form method="post" action="${cp }/admin/product/productUpdate" 
					enctype="multipart/form-data" onsubmit = "return prodValidate();">
					<input type = "hidden" name = "prod_num" value = "${vo.prod_num }">
					<table class="table table-hober">
						<tr>
							<td style="text-align: center;">카테고리</td>
							<td>
								<select name = "cate" onchange="getMenu(this.value, '${cp }')">
									<option value = "">- [필수]선택 -</option>
									<option value = "0"
										<c:if test = "${vo.menu_num == 0}">
											selected = "selected"
										</c:if>
									>CLOTHING</option>
									<option value = "1"
										<c:if test = "${vo.menu_num >= 1 && vo.menu_num <= 2}">
											selected = "selected"
										</c:if>
									>FOOD</option>
									<option value = "2"
										<c:if test = "${vo.menu_num >= 3 && vo.menu_num <= 5}">
											selected = "selected"
										</c:if>
									>TOY</option>
									<option value = "3"
										<c:if test = "${vo.menu_num >= 6 && vo.menu_num <= 8}">
											selected = "selected"
										</c:if>
									>ETC</option>
								</select>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;">메뉴</td>
							<td>
								<select name = "menu"></select>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;">상품명</td>
							<td><input type = "text" style="width: 400px;" name = "name" value = "${vo.prod_name }"></td>
						</tr>
						<tr>
							<td style="text-align: center;">가격</td>
							<td><input type = "text" style="width: 400px;" name = "price" value = "${vo.prod_price }"></td>
						</tr>
						<tr>
							<td style="text-align: center;">옵션</td>
							<td>
								<input type = "button" class="btn btn-primary" value = "옵션추가" id = "btnAdd" onclick="addDivOp()" style = "display: none;">
								<div id = "op">
									<input type = "button" value = "옵션삭제" id = "btnDel" onclick="delDivOp(this.parentNode.id)"><br> 
									옵션명 <input type = "text" name = "op" value = "${op_name }">
									<input type = "button" value = "세부옵션추가" onclick="addDivDetailOp()">
									<c:set var = "i" value = "1"/>
									<c:forEach var = "dvo" items = "${dlist }">
										<div id = "detailOp${i }">
											세부옵션명 <input type = "text" name = "detailOp" value = "${dvo.detailOp_name }"><br>
											추가가격 <input type = "text" name = "detailOpPrice" value = "${dvo.detailOp_price }"><br>
											<input type = "button" value = "세부옵션삭제" onclick="delDivDetailOp(this.parentNode.id)"> 
										</div>
										<c:set var = "i" value = "${i + 1 }"/>
									</c:forEach>
								</div>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;">썸네일이미지</td>
							<td><input type = "file" name = "img"></td>
						</tr>
						<tr>
							<td rowspan = "3" style="text-align: center;">상품이미지</td>
							<td><input type = "file" name = "pimg1"></td>
						</tr>
						<tr>
							<td><input type = "file" name = "pimg2"></td>
						</tr>
						<tr>
							<td><input type = "file" name = "pimg3"></td>
						</tr>
						<tr>
							<td rowspan = "3" style="text-align: center;">상세설명이미지</td>
							<td><input type = "file" name = "dimg1"></td>
						</tr>
						<tr>
							<td><input type = "file" name = "dimg2"></td>
						</tr>
						<tr>
							<td><input type = "file" name = "dimg3"></td>
						</tr>
						<tr>
							<td colspan = "2" style="text-align: center;">
								<div id = "msg" style = "color: red; font-size: 12px;"></div>
								<input class="btn btn-primary" type = "submit" value = "등록">
								<input class="btn btn-primary" type = "button" value = "취소" onclick="javascript:history.go(-1)">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div> <!-- // row -->
   </div> <!-- // container -->
</div> <!-- //site-section -->