<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">mypage</strong>
         </div>
       </div>
     </div>
   </div>
<!-- // 카테고리명 -->
<div class="site-section">
	<div class="container">
		<div class = "row">
		<div class = "col-md-12" >
			<!-- 해당 사이트 제목 -->
			<div class="col-md-12 mb-6">
               <div class="float-md-left mb-4"><h2 class="text-black h5">문의</h2></div>
            </div><br><br>
<div style="width: 60%; margin-left: 20%; margin-right: 20%; font-weight: bold;font-size:large;">[ <span class="text-primary h4">${sessionScope.mem_id }</span> ] 님 환영합니다.</div><br>

<div style = "width: 60%; margin-left: 20%; margin-right: 20%;">
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
         <a href="${cp }/mypage/myInfo.do" class="btn btn-outline-primary" style="margin-bottom: 10px;">회원정보</a>
         <i class="fas fa-user-cog" style="font-size: 2em; float: right;"></i><br>
        <p class="card-text">회원이신 고객님의 개인정보를 관리하는 공간입니다.</p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <a href="${cp }/mypage/orderList" class="btn btn-outline-primary" style="margin-bottom: 10px;">주문내역</a>
        <i class="fas fa-file-invoice" style="font-size: 2em; float: right;"></i><br>
        <p class="card-text">고객님께서 주문하신 상품의 주문내역을 확인하실 수 있습니다.</p>
      </div>
    </div>
  </div>
</div>
<br>
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
         <a href="${cp }/mypage/interList.do" class="btn btn-outline-primary" style="margin-bottom: 10px;">관심상품</a>
         <i class="fas fa-heart" style="font-size: 2em; float: right;"></i><br>
        <p class="card-text">관심상품으로 등록하신 상품의 목록을 보여드립니다.</p>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body" style="display:inline;">
      <a href="${cp }/mypage/myqna" class="btn btn-outline-primary" style="margin-bottom: 10px;">나의 문의</a>
      <a href="${cp }/mypage/myreview" class="btn btn-outline-primary" style="margin-bottom: 10px;">나의 후기</a>
      <i class="fas fa-edit" style="font-size: 2em; float: right;"></i><br>
        <p class="card-text">고객님께서 작성하신 게시물을 관리하는 공간입니다.</p>
        </div>
    </div>
  </div>
  </div>
</div>
</div>
</div>
</div>
</div>