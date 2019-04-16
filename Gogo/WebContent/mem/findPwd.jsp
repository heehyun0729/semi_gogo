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
<div id="board" class="login-wrapper">
	<div class="box" style="width:50%;text-align:center;margin:auto;padding-top:5%;padding-bottom:5%;" >
		<div class="content_wrap">
			<div class="box">
				<h4>비밀번호 찾기</h4>
					<form method="post" action="${cp }/mem/findPwd.do">
						<div class="gogo_findPwd">
						</div>
						<input class="form-control" type="text" name="mem_id" placeholder="아이디" style="width:30%;margin:auto;">
						<input class="form-control" type="text" name="mem_email" placeholder="이메일" style="width:30%;margin:auto;">
						<div style="color:red;font-size:12px;">${msg }</div>
						<br>
						<input type="submit" value="찾기" class="btn btn-sm btn-primary">
				</form> 
			</div>
		</div>
	</div>
</div>