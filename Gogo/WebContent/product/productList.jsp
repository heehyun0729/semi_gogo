<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
          	<c:if test="${menu_num > 0 }">
          		<span class="mx-2 mb-0">/</span> <strong class="text-black">${cate_name }</strong>
          	</c:if> 
          	<span class="mx-2 mb-0">/</span> <strong class="text-black">${menu_name }</strong>
          </div>
        </div>
      </div>
    </div>	
    
    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12">

            <div class="row">
              <div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">${menu_name }</h2></div>
              </div>
            </div>
            <div class="row mb-5">
			 <c:forEach var = "vo" items = "${list }">
				 <div class="col-sm-6 col-lg-3 mb-4" data-aos="fade-up">
	                <div class="block-4 text-center border">
	                  <figure class="block-4-image">
	                    <a href="${cp }/product/productDetail.do?prod_num=${vo.prod_num}&menu_num=${vo.menu_num }"><img src="${cp }/upload/product/${vo.img_saveImg}" alt="Image placeholder" class="img-fluid"></a>
	                  </figure>
	                  <div class="block-4-text p-4">
	                    <h3><a href="${cp }/product/productDetail.do?prod_num=${vo.prod_num}&menu_num=${vo.menu_num }">${vo.prod_name}</a></h3>
	                    <p class="text-primary font-weight-bold">${vo.prod_price }</p>
	                  </div>
	                </div>
	              </div>
				</c:forEach>
            </div>
            
            <c:choose>
            	<c:when test="${startPage!=null}">
		            <div class="row" data-aos="fade-up">
		              <div class="col-md-12 text-center">
		                <div class="site-block-27">
		                  <ul>
		                  <c:choose>
							<c:when test="${startPage > 4 }">
								<li><a href = "${cp }/product/productList.do?pageNum=${startPage - 1}&menu_num=${menu_num }">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a>&lt;</a></li>
							</c:otherwise>
							</c:choose>
								<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<li><a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }">${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }">${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < pageCnt }">
									<li><a href = "${cp }/product/productList.do?pageNum=${endPage + 1}&menu_num=${menu_num }">&gt;</a></li>
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
          </div>
         </div>
        </div>
        </div>