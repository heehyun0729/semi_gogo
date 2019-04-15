<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "box">
	<div id = "logo">
			<h1><a href = "${cp }/home">GOGO</a></h1>
			<h3>고장난 고양이</h3>
	</div>
	<ul>
		<li><a href = "${cp }/product/productList.do?menu_num=0">CLOTHING</a></li>
		<li><a>FOOD</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=1">사료</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=2">간식</a></li>
		<li><a>TOY</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=3">낚싯대</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=4">터널</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=5">인형</a></li>
		<li><a>ETC</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=6">모래</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=7">정수기</a></li>
		<li><a href = "${cp }/product/productList.do?menu_num=8">스크래쳐</a></li>
		<li><a>COMMUNITY</a></li>
		<li><a href = "${cp }/board/noticeList.do?menu_num=9">공지</a></li>
		<li><a href = "${cp }/board/qna?menu_num=10">문의</a></li>
		<li><a href = "${cp }/board/review?menu_num=11">후기</a></li>
		<li><a href = "${cp }/freedom/freedomList.do?menu_num=12">자유게시판</a></li>
	</ul>
	<ul>
		<c:if test="${sessionScope.mem_id == 'admin'}">
			<li><a href = "${cp }/admin/home">ADMIN</a></li>
		</c:if>
		<c:choose>
			<c:when test="${empty sessionScope.mem_id }">
				<li><a href ="${cp }/mem/login">LOGIN</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${cp}/mem/logout">LOGOUT</a></li>
			</c:otherwise>
		</c:choose>
		<c:if test="${!empty sessionScope.mem_id }">
			<li><a href = "${cp }/mypage/home">MYPAGE</a></li>
			<li><a href = "${cp }/order/basketList.do">BASKET</a></li>
		</c:if>
		<li><form action="${cp }/product/findProduct.do"><input type="text" name="find_prod_name"><input type="submit" value="상품검색"></form></li>
	</ul>
</div>