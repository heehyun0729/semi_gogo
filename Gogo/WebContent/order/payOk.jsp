<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">order</strong>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">결제완료</strong>
         </div>
       </div>
     </div>
   </div>
<!-- // 카테고리명 -->
<div class="site-section">
  <div class="container">
    <div class="row">
      <div class="col-md-12 text-center">
        <span class="icon-check_circle display-3 text-success"></span>
        <h2 class="display-3 text-black">Thank you!</h2>
        <p class="lead mb-5">주문이 성공적으로 완료되었습니다.</p>
        <p>
        	<a href="${cp }/home" class="btn btn-sm btn-primary">메인으로</a>
        	<a href="${cp }/mypage/orderList" class="btn btn-sm btn-primary">주문내역</a>
        </p>
      </div>
    </div>
  </div>
</div>