<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">PRODUCT</strong>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">상품등록</strong>
       </div>
     </div>
   </div>
</div>

<div class="site-section">
	<div class="container">
		<div class="row" >
			<!-- 해당 사이트 제목 -->
				<div class="col-md-12 mb-6">
	               <div class="float-md-left mb-4"><h2 class="text-black h5">상품등록</h2></div>
	            </div>
			<!--// 해당 사이트 제목 -->
			<div style="width: 70%;margin-left: 15%;margin-right: 15%;">
				<form method="post" action="${cp }/admin/product/productInsert" 
					enctype="multipart/form-data" onsubmit = "return prodValidate();">
					<table class="table table-hober">
						<tr>
							<td style="text-align: center;">카테고리</td>
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
							<td style="text-align: center;">메뉴</td>
							<td>
								<select name = "menu"></select>
							</td>
						</tr>
						<tr>
							<td style="text-align: center;">상품명</td>
							<td><input type = "text" style="width: 400px;" name = "name"></td>
						</tr>
						<tr>
							<td style="text-align: center;">가격</td>
							<td><input type = "text" style="width: 400px;" name = "price"></td>
						</tr>
						<tr>
							<td style="text-align: center;">옵션</td>
							<td>
								<input type = "button" class="btn btn-primary" value = "옵션추가" id = "btnAdd" onclick="addDivOp()">
								<div id = "op">
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
								<input type = "submit" class="btn btn-primary" value = "등록">
								<input type = "button" class="btn btn-primary" value = "취소" onclick="javascript:history.go(-1)">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div> <!-- // row -->
   </div> <!-- // container -->
</div> <!-- //site-section -->