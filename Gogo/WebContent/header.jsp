<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="site-navbar-top">
  <div class="container">
    <div class="row align-items-center">

      <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
        <form action="${cp }/product/findProduct.do" class="site-block-top-search">
          <span class="icon icon-search2"></span>
          <input type="text" class="form-control border-0" name = "find_prod_name" placeholder="Search">
        </form>
      </div>

      <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
        <div>
          <a href="${cp }/home"><img src = "${cp }/images/logo_violet.png"></a>
        </div>
      </div>

      <div class="col-6 col-md-4 order-3 order-md-3 text-right">
        <div class="site-top-icons">
	        <ul>
				<c:if test="${sessionScope.mem_id == 'admin'}">
					<li><a href = "${cp }/admin/home"><span class="fas fa-tools"></span></a></li>
				</c:if>
				<c:choose>
					<c:when test="${empty sessionScope.mem_id }">
						<li><a href ="${cp }/mem/login"><span class="fas fa-sign-in-alt"></span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${cp}/mem/logout"><span class="fas fa-sign-out-alt"></span></a></li>
					</c:otherwise>
				</c:choose>
				<c:if test="${!empty sessionScope.mem_id}">
					<li><a href = "${cp }/mypage/home"><span class="icon icon-person"></span></a></li>
					<li><a href = "${cp }/order/basketList.do"><span class="icon icon-shopping_cart"></span></a></li>
				</c:if>
			</ul>
        </div> 
      </div>
    </div>
 </div>
</div> 
  <nav class="site-navigation text-right text-md-center" role="navigation">
  <div class="container">
    <ul class="site-menu js-clone-nav d-none d-md-block">
      <li><a href="${cp }/product/productList.do?menu_num=0">CLOTHING</a></li>
      <li class="has-children">
        <a>FOOD</a>
        <ul class="dropdown">
          <li><a href="${cp }/product/productList.do?menu_num=1">사료</a></li>
          <li><a href="${cp }/product/productList.do?menu_num=2">간식</a></li>
          </ul>
        </li>
         <li class="has-children">
          <a>TOY</a>
          <ul class="dropdown">
			<li><a href = "${cp }/product/productList.do?menu_num=3">낚싯대</a></li>
			<li><a href = "${cp }/product/productList.do?menu_num=4">터널</a></li>
			<li><a href = "${cp }/product/productList.do?menu_num=5">인형</a></li>
          </ul>
        </li>
         <li class="has-children">
          <a>ETC</a>
          <ul class="dropdown">
			<li><a href = "${cp }/product/productList.do?menu_num=6">모래</a></li>
			<li><a href = "${cp }/product/productList.do?menu_num=7">정수기</a></li>
			<li><a href = "${cp }/product/productList.do?menu_num=8">스크래쳐</a></li>
          </ul>
        </li>
         <li class="has-children">
          <a>COMMUNITY</a>
          <ul class="dropdown">
			<li><a href = "${cp }/board/noticeList.do?menu_num=9">공지</a></li>
			<li><a href = "${cp }/board/qna?menu_num=10">문의</a></li>
			<li><a href = "${cp }/board/review?menu_num=11">후기</a></li>
			<li><a href = "${cp }/freedom/freedomList.do?menu_num=12">자유게시판</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>