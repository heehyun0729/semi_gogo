<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 카테고리명 -->
<div class="bg-light py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
    		  <span class="mx-2 mb-0">/</span> <strong class="text-black">mypage</strong>
      	<span class="mx-2 mb-0">/</span> <strong class="text-black">주문내역</strong>
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
               <div class="float-md-left mb-4"><h2 class="text-black h5">주문내역</h2></div>
            </div>
            <!-- // 해당 사이트 제목 -->
            <!-- 검색창 -->
			<div class="row text-center" style="width: 100%">
                  <div style="width: 50%; float:none; margin:0 auto" >
                   <div id = "search">
					<form method="post" action="${cp }/mypage/orderList" class = "col-md-12">
						<strong class = "text-black">기간별 조회 (yyyy-mm-dd)   </strong>
						<input type = "text" name = "startDate" value = "${startDate }" class="form-control col-sm-3" style = "display: inline-block;"> ~
						<input type = "text" name = "endDate" value = "${endDate }" class="form-control col-sm-3" style = "display: inline-block;">
						<input type = "submit" class="btn btn-primary" value = "조회"><br><br>
					</form>
				</div>
               </div>
             </div>
	        <!-- //검색창 -->
            <!-- 테이블 -->
            <table class="table table-hover">
			 	<thead>
				<tr class="text-center">
					<th>주문일자<br>[주문번호]</th>
					<th>이미지</th>
					<th>상품정보</th>
					<th>수량</th>
					<th>구매금액</th>
					<th>주문처리상태</th>
				</tr>
				</thead>
				<c:set var = "i" value = "0"/>
				<tbody>
				<c:forEach var = "vo" items = "${list }">
				<c:set var = "prevNum" value = "${vo.buy_num }"/>
					<tr class="text-center">
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
								<div id = "op"><br>[옵션: ${vo.op_name } - ${vo.detailOp_name } (+${vo.detailOp_price })]</div>
							</c:if>
						</td>
						<td>${vo.cnt }</td>
						<td>${vo.price }원</td>
						<td>
							결제완료<br>
							<c:if test="${vo.detailBuy_review == 0}">
								<a class= "btn btn-outline-primary" href = "${cp }/board/reviewInsert?detailBuy_num=${vo.detailBuy_num}&prod_name=${vo.prod_name}&op_name=${vo.op_name}&detailOp_name=${vo.detailOp_name}&detailOp_price=${vo.detailOp_price}">구매후기</a>
							</c:if>
						</td>
					</tr>		
					<c:set var = "i" value = "${i + 1 }"/>
					<c:if test="${i == vo.length }">
						<c:set var = "i" value = "0"/>
					</c:if>			
				</c:forEach>
				</tbody>
			</table>
            <!-- // 테이블 -->
             <!-- 페이징처리 -->
	            <c:choose>
            	<c:when test="${startPage!=null}">
		            <div class="row text-center" style="width: 100%;margin-top:50px;" data-aos="fade-up">
		              <div class="col-md-12 text-center">
		                <div class="site-block-27">
		                  <ul>
		                  <c:choose>
							<c:when test="${startPage > 10 }">
								<li><a href = "${cp }/mypage/orderList?pageNum=${startPage - 1}">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a>&lt;</a></li>
							</c:otherwise>
							</c:choose>
								<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<li><a href = "${cp }/mypage/orderList?pageNum=${i}">${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a href = "${cp }/mypage/orderList?pageNum=${i}">${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < pageCnt }">
									<li><a href = "${cp }/mypage/orderList?pageNum=${endPage + 1}">&gt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a>&gt;</a></li>
								</c:otherwise>
							</c:choose>
		                  </ul>
		                </div>
		              </div>
		            </div>
	            </c:when>
            </c:choose>	                
	       <!-- // 페이징처리 -->
         </div> <!-- // row -->
     </div> <!-- // container -->
  </div> <!-- //site-section -->