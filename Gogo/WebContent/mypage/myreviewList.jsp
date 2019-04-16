<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!-- 카테고리명 -->
		<div class="bg-light py-3">
		     <div class="container">
		       <div class="row">
		         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         			<span class="mx-2 mb-0">/</span> <a href="${cp }/mypage/home">mypage</a>
		         	<span class="mx-2 mb-0">/</span> <strong class="text-black">나의 후기</strong>
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
		               <div class="float-md-left mb-4"><h2 class="text-black h5">나의 후기</h2></div>
		            </div>
		            <!-- // 해당 사이트 제목 -->
		            <div style = "width: 100%;margin-bottom: 20px;">
		            <a class="btn btn-primary" href = "${cp }/board/reviewInsert?menu_num=11" style = "float: right;">글쓰기</a>
		            </div>
		            <!-- 테이블 -->
		            <table class="table table-hover">
					 	<thead>
						<tr>
							<th class="text-center">상품사진</th>
							<th class="text-center">상품명</th>
							<th class="text-center">제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">별점</th>
							<th class="text-center">추천수</th>
							<th class="text-center">작성일</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var = "vo" items = "${list }">
							<tr class="text-center">
								<td>
									<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
										<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px;height: 100px;">
									</a>
								</td>
								<td>
									<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">${vo.prod_name }</a>
									<c:if test="${vo.prod_name != vo.op_name }">
										<br>[옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
									</c:if>
								</td>
								<td><a href = "${cp }/board/reviewDetail?review_num=${vo.review_num}">${vo.review_title }</a></td>
								<td>${vo.mem_id }</td>
								<td><img src = "${cp }/images/star${vo.review_star }.png" style = "width: 100px"></td>
								<td>${vo.review_like }</td>
								<td>${vo.review_wdate }</td>
							</tr>							
						</c:forEach>
						</tbody>
					</table>
		            <!-- // 테이블 -->
		            
		            <!-- 검색창 -->
					<div class="row text-center" style="width: 100%">
	                    <div style="width: 50%; float:none; margin:0 auto" >
		                    <div id = "search">
		                    	<form method="post" action="${cp }/mypage/myreview?menu_num=${menu_num}">
									<strong class = "text-black">상품명   </strong>
									<input type = "text" name = "keyword" value = "${keyword }" class="form-control col-sm-5" style = "display: inline-block;">
									<input type = "submit" class="btn btn-primary" value = "조회">
								</form>
							</div>
	                    </div>
	                </div>
	                <!-- //검색창 -->
	                
	                <!-- 페이징처리 -->
	                <c:choose>
            	<c:when test="${startPage!=null}">
		            <div class="row text-center" style="width: 100%;margin-top:50px;" data-aos="fade-up">
		              <div class="col-md-12 text-center">
		                <div class="site-block-27">
		                  <ul>
		                  <c:choose>
							<c:when test="${startPage > 10 }">
								<li><a href = "${cp }/board/review?pageNum=${startPage - 1}">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a>&lt;</a></li>
							</c:otherwise>
							</c:choose>
								<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<li><a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${i}">${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${i}">${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < pageCnt }">
									<li><a href = "${cp }/board/review?menu_num=${menu_num}&pageNum=${endPage + 1}">&gt;</a></li>
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