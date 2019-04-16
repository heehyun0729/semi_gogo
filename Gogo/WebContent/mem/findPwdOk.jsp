<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 카테고리명 -->
<div class="bg-light py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
      	<span class="mx-2 mb-0">/</span> <strong class="text-black">비밀번호찾기</strong>
      </div>
    </div>
  </div>
</div>
<!-- // 카테고리명 -->
<div id="board">
	<div class="box" style="width:60%;text-align:center;margin:auto;padding-top:5%;padding-bottom:5%;" >
		<h6>조회된 비밀번호는</h6>
		<div class="font" style="display:inline;">
			<input class="form-control" type="text" name="mem_pwd" value="${result}" style="width:15%;margin:auto;text-align:center;color:black;font-weight:bold;">입니다.
			</div><br><br>
			<a href="${cp }/mem/login">로그인페이지</a>
	</div>
</div>