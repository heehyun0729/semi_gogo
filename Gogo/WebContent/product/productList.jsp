<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board">
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
	<c:forEach var = "vo" items = "${list }">
		<div style="display: inline-block; float: left;">
			<a href = "${cp }/product/productDetail.do?prod_num=${vo.prod_num}&menu_num=${vo.menu_num }">
				<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px; height: 100px;"><br>
				${vo.prod_name}<br>
				${vo.prod_price }
			</a>
		</div>
	</c:forEach>
	
	<c:choose>
		<c:when test="${pageNum!=null }">
			<div id = "pages" style = "clear: both;">
				<c:choose>
					<c:when test="${startPage > 4 }">
						<a href = "${cp }/product/productList.do?pageNum=${startPage - 1}&menu_num=${menu_num }">◀</a>
					</c:when>
					<c:otherwise>
						◀
					</c:otherwise>
				</c:choose>
				<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
					<c:choose>
						<c:when test="${pageNum == i }">
							<a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }"><span style = "color: pink;">[${i }]</span></a>
						</c:when>
						<c:otherwise>
							<a href = "${cp }/product/productList.do?pageNum=${i}&menu_num=${menu_num }"><span style = "color: gray;">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${endPage < pageCnt }">
						<a href = "${cp }/product/productList.do?pageNum=${endPage + 1}&menu_num=${menu_num }">▶</a>
					</c:when>
					<c:otherwise>
						▶
					</c:otherwise>
				</c:choose>
			</div>
		</c:when>
	</c:choose>					
</div>