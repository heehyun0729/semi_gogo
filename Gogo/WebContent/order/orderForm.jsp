<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       		  <span class="mx-2 mb-0">/</span> <strong class="text-black">order</strong>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">주문서작성</strong>
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
               <div class="float-md-left mb-4"><h2 class="text-black h5">주문서작성</h2></div>
            </div>
            <!-- // 해당 사이트 제목 -->
            <div class="col-md-2" style = "margin-bottom: 20px;">
         	   <input type = "button" class = "buy-now btn btn-sm" value = "이전페이지" onclick="javascript:history.go(-1)">
            </div>
            <br><br>
            <!-- 테이블 -->
            <div class="col-md-12">
           	 <h2 class="text-black">주문상품목록</h2>
            </div>
            <table class="table table-hover">
			 	<thead>
				<tr class="text-center">
					<th>이미지</th>
					<th>상품정보</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var = "vo" items = "${list }">
					<tr class="text-center">
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
						<td>${vo.cnt }</td>
						<td>${vo.tot }원</td>
					</tr>		
					<c:set var = "sum" value = "${sum + vo.tot}"/>			
				</c:forEach>
				<tr class = "text-center">
					<td colspan = "8">합계: <span class="text-primary h4">${sum }</span>원</td>
				</tr>
				</tbody>
			</table>
			
			<br>
			<br><br>
			<div style = "width: 60%; margin-left: 20%; margin-right: 20%; margin-top: 50px;">
			 <form method="post" action="${cp }/order/payInsert" onsubmit="buyValidate()">
              	<input type = "hidden" name = "buy_num" value = "${buy_num }">
				<div class="col-md-12" style = "margin-top: 20px;">
					<h2 class="text-black">배송정보</h2>
				</div>
              <div class="p-5 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label class="text-black">배송지 선택 </label>
                    <input type = "radio" name = "ship" checked="checked" onclick="setShip('${mvo.mem_name }', '${mvo.mem_addr }', '${mvo.mem_phone }', '${mvo.mem_email }')">회원 정보와 동일
					<input type = "radio" name = "ship" onclick="setShip('${mvo.mem_name }', '${mvo.mem_addr }', '${mvo.mem_phone }', '${mvo.mem_email }')">새로운 배송지
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="name" class="text-black">받으시는 분</label>
                    <input type = "text" id = "name" name = "name" value = "${mvo.mem_name }" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="addr" class="text-black">주소 </label>
                    <textarea name="addr" id="addr" cols="30" rows="7" class="form-control">${mvo.mem_addr }</textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="phone" class="text-black">전화번호</label>
                    <input type = "text" id = "phone" name = "phone" value = "${mvo.mem_phone }" class="form-control">
                  </div>
                   <div class="col-md-6">
                    <label for="email" class="text-black">이메일</label>
                    <input type = "text" id = "email" name = "email" value = "${mvo.mem_email }" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="shipmsg" class="text-black">배송메시지 </label>
                    <textarea name="shipmsg" id="shipmsg" cols="30" rows="7" class="form-control">${mvo.mem_addr }</textarea>
                  </div>
                </div>
                <div id = "msg" style="color: red;font-size: 12px;"></div>
              </div>
            
            <br>
            <div class="col-md-12" style = "margin-top: 20px;">
            <h2 class="text-black">결제수단</h2>
            </div>
            <input type = "hidden" name = "pay_sum" value = "${sum }">
            <div class="p-5 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                  		<input type = "radio" name = "payhow" value = "무통장" checked="checked" onclick = "setPayHow()">무통장입금
						<input type = "radio" name = "payhow"  value = "계좌이체" onclick = "setPayHow()">계좌이체
						<input type = "radio" name = "payhow" value = "카드결제" onclick = "setPayHow()">카드결제
						<input type = "radio" name = "payhow" value = "휴대폰결제" onclick = "setPayHow()">휴대폰 결제
                  </div>
                </div>
                <div id = "noaccount" class="form-group row">
                  <div class="col-md-12">
                    <label for="payname" class="text-black">입금자명</label>
                    <input type = "text" id = "payname" name = "payname" class="form-control">
                  </div>
                </div>
                <div id = "account" class="form-group row" style="display: none;">
                  <div class="col-md-12">
                    <label for="accountname" class="text-black">예금주명 </label>
                    <input type = "text" id = "accountname" name = "accountname" class="form-control">
                  </div>
                </div>
                <div id = "paymsg" class="form-group row" style="display: none;">
                  <div class="col-md-12">
                    <div class="text-black">소액 결제의 경우 PG사 정책에 따라 결제 금액 제한이 있을 수 있습니다.</div>
                  </div>
                </div>
              </div>
              <br><br>
              <div class="card">
				  <div class="card-header h2 text-center">
				  	 최종결제금액
				  </div>
				  <div class="card-body text-center">
				    <p class="card-text"><span class="text-primary h3">${sum }</span>원</p>
				    <input type = "submit" class = "btn btn-primary" value = "결제하기">
				  </div>
				</div>
            </form>
            </div>
            <!-- // 테이블 -->
         </div> <!-- // row -->
     </div> <!-- // container -->
  </div> <!-- //site-section -->