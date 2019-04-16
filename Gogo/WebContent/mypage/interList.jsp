<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
    		<span class="mx-2 mb-0">/</span><a href="${cp }/myoage/home">mypage</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">관심상품</strong>
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
             <div class="float-md-left mb-4"><h2 class="text-black h5">관심상품</h2></div>
          </div>
          <!-- // 해당 사이트 제목 -->
          <!-- 테이블 -->
          <form method="post" class = "col-md-12" action="${cp }/mypage/interDelete.do?select=ck">
          <table class="table table-hover">
		 	<thead>
			<tr class="text-center">
				<th><input type = "checkbox" id = "ckAll" onclick="checkAll()"></th>
				<th>이미지</th>
				<th>상품정보</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
			</thead>
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
					</td>
					<td>${vo.price }원</td>
					<td>
						<a href = "${cp }/mypage/interDelete.do?select=one&inter_num=${vo.inter_num}" class = "buy-now btn btn-sm">삭제</a>
					</td>
				</tr>				
			</c:forEach>
			</tbody>
		</table>
	<div style = "row">
		<input type = "submit" class = "ㅁbtn btn-sm" value = "선택상품삭제" style = "float: left;margin-right: 5px;">
		<input type = "submit" class = "btn btn-sm" value = "관심상품 비우기" onclick="javascript: form.action='${cp }/mypage/interDelete.do?select=all'" style = "float: right;margin-left: 5px;">
		<input type = "button" class = "btn btn-sm btn-outline-primary" onclick = "javascript:history.go(-1)" value = "쇼핑계속하기" style = "float: right;">
	</div>
	</form>
          <!-- // 테이블 -->
         </div> <!-- // row -->
     </div> <!-- // container -->
  </div> <!-- //site-section -->