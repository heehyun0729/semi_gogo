<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 카테고리명 -->
<div class="bg-light py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
      	<span class="mx-2 mb-0">/</span> <strong class="text-black">로그인</strong>
      </div>
    </div>
  </div>
</div>
<!-- // 카테고리명 -->
<div id="board" class="login-wrapper">
	<div class="box" style="width:50%;text-align:center;margin:auto;padding-top:5%;padding-bottom:10px" >
		<div class="content_wrap">
			<div class="box">
				<h2>LOGIN</h2>
					<form method="post" action="${cp }/mem/login">
						<div class="gogo_login">
						</div>
						<input class="form-control" type="text" class="form-control" name="mem_id" placeholder="ID" style="width:30%;margin:auto;">
						<input class="form-control" type="password" name="mem_pwd" placeholder="Password" style="width:30%;margin:auto;">
						<div style="color:red;font-size:12px;">${errMsg }</div>
						<div style="color:red;font-size:12px;">${errMsg2 }</div>
						<br>	
						<input type="submit" value="로그인" class="btn btn-sm btn-primary signup" style = "margin-bottom: 20px;">
			<div id="tag">
				<p>아직 회원이 아니신가요?   <a href="${cp }/mem/join">회원가입하기</a></p>
				<a href="${cp }/mem/findId.do">아이디·</a> <a href="${cp }/mem/findPwd.do">비밀번호찾기</a>
			</div>
				</form> 
			</div>
			</div>
		</div>
	</div>