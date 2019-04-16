<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="all" style="width: 40%; height: 50%; margin: auto;">
<h1>MYPAGE</h1>
<div style="color:grey;font-weight: bold;font-size:large;display:inline;">[ ${sessionScope.mem_id } ] 님 환영합니다.</div><br>
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
         <a href="${cp }/mypage/myInfo.do" class="btn btn-primary">회원정보</a>
        <p class="card-text"><a href="${cp }/mypage/myInfo.do">회원이신 고객님의 개인정보를 관리하는 공간입니다.</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <a href="${cp }/mypage/orderList" class="btn btn-primary">주문내역</a>
        <p class="card-text"><a href="${cp }/mypage/orderList">고객님께서 주문하신 상품의 주문내역을 확인하실 수 있습니다.</a></p>
      </div>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
         <a href="${cp }/mypage/interList.do" class="btn btn-primary">관심상품</a>
        <p class="card-text"><a href="${cp }/mypage/interList.do">관심상품으로 등록하신 상품의 목록을 보여드립니다.</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body" style="display:inline;">
      <a href="#" class="btn btn-primary">게시글관리</a>
        <a href="${cp }/mypage/myqna">나의문의</a> <a href="${cp }/mypage/myreview">나의후기</a>
        <p class="card-text"><a href="#">고객님께서 작성하신 게시물을 관리하는 공간입니다.</a></p>
        </div>
    </div>
  </div>
</div>
</div>