<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       		  <span class="mx-2 mb-0">/</span> <strong class="text-black">order</strong>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">장바구니</strong>
         </div>
       </div>
     </div>
   </div>
<!-- // 카테고리명 -->
<div class="site-section">
	<div class="container">
		<div class="row">
		
			<!-- 해당 사이트 제목 -->
			<div class="col-md-12 mb-5">
               <div class="float-md-left mb-4"><h2 class="text-black h5">장바구니</h2></div>
            </div>
            <!-- // 해당 사이트 제목 -->
            <!-- 테이블 -->
            <form method="post" class = "col-md-12">
            <table class="table table-hover">
			 	<thead>
				<tr class="text-center">
					<th><input type = "checkbox" id = "ckAll" onclick="checkAll()"></th>
					<th>이미지</th>
					<th>상품정보</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
					<th>선택</th>
				</tr>
				</thead>
				<c:set var = "i" value = "1"/>
				<tbody>
				<c:forEach var = "vo" items = "${list }">
					<tr class="text-center">
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
								<div id = "op"><br>[옵션: ${vo.op_name } - ${vo.detailOp_name } (+${vo.detailOp_price })]</div>
							</c:if>
						</td>
						<td>${vo.price }원</td>
						<td>
							 <div class="input-group" style="max-width: 120px;margin-left: 25%;">
				              <div class="input-group-prepend">
				                <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
				              </div>
				              <input type="text" id="cnt${i }" value="${vo.cnt }" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
				              <div class="input-group-append">
				                <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
				              </div>
				              </div><br>
							<input type = "button" class = "buy-now btn btn-sm" value = "수정" onclick="changeCnt('${cp}', 'cnt${i}','${vo.basket_num }')">
						</td>
						<td>${vo.tot }원</td>
						<td>
							<a href = "${cp }/mypage/interInsert.do?prod_num=${vo.prod_num }" class = "buy-now btn btn-sm">관심상품등록</a><br>
							<a href = "${cp }/order/basketDelete.do?select=one&basket_num=${vo.basket_num}" class = "buy-now btn btn-sm">삭제</a>
						</td>
					</tr>		
					<c:set var = "sum" value = "${sum + vo.tot}"/>
					<c:set var = "i" value = "${i + 1 }"/>					
				</c:forEach>
				<tr class = "text-center">
					<td colspan = "8">합계: <span class="text-primary h4" style="display: inline-block;">${sum }</span>원</td>
				</tr>
				</tbody>
			</table>
			<div style = "row">
				<input type = "submit" class = "buy-now btn btn-sm" value = "선택상품삭제" onclick="javascript: form.action='${cp }/order/basketDelete.do?select=ck'" style = "float: left;margin-right: 5px;">
				<input type = "submit" class = "buy-now btn btn-sm btn-primary" value = "선택상품주문" onclick="javascript: form.action='${cp }/order/buyInsert?select=ck'" style = "float: left;margin-right: 5px;">
				<input type = "submit" class = "buy-now btn btn-sm btn-primary" value = "전체상품주문" onclick="javascript: form.action='${cp }/order/buyInsert?select=all'" style = "float: left;">
				<input type = "button" class = "buy-now btn btn-sm" onclick = "javascript:'${cp }/order/basketDelete.do?select=all'" value = "장바구니 비우기" style = "float: right;margin-left: 5px;">
				<input type = "button" class = "buy-now btn btn-sm btn-outline-primary" onclick = "javascript:history.go(-1)" value = "쇼핑계속하기" style = "float: right;">
			</div>
			</form>
            <!-- // 테이블 -->
         </div> <!-- // row -->
     </div> <!-- // container -->
  </div> <!-- //site-section -->