<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<h1>MYPAGE</h1>
	<h3>마이페이지</h3>
	<div>[${sessionScope.mem_id }]님 환영합니다.</div>
	<ul> 
		<li><a href = "${cp }/mypage/myInfo.do">회원정보</a></li>
		<li><a href = "${cp }/mypage/orderList">주문내역</a></li>
		<li><a href = "${cp }/mypage/interList.do">관심상품</a></li>
		<li><a href = "${cp }/mypage/myqna">나의 문의</a></li>
		<li><a href = "${cp }/mypage/myreview">나의 후기</a></li>
	</ul>
</div>