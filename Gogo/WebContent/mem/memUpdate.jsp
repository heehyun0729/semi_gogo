<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 카테고리명 -->
<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <a href="${cp }/mypage/home">mypage</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">회원정보수정</strong>
         </div>
       </div>
     </div>
   </div>
<!-- // 카테고리명 -->
<!-- // 카테고리명 -->
<div class="site-section">
	<div class="container">
		<!-- 해당 사이트 제목 -->
		<div class="col-md-12 mb-5">
		   <div class="float-md-left mb-4"><h2 class="text-black h5">회원정보수정</h2></div>
		</div>
		<!-- // 해당 사이트 제목 -->
  </div> <!-- // container -->
</div> <!-- //site-section -->
		<div class="content_wrap" style="padding-bottom: 5%">
		<div id="box" style="width: 40%; height: 50%; margin: auto;">
		<form method="post" action="${cp }/mypage/myInfo.do"
			onsubmit="return validate();">
			<table class="table table-striped">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mem_pwd" class="form-control"
						value="${vo.mem_pwd }" id="pwd" onkeyup="pwdcheck()">(영문소문자/숫자,
						8자~16자)</td>
				</tr> 
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="re_pwd" id="repwd" class="form-control"
						value="${vo.mem_pwd }" onkeyup="pwdcheck()"></td>
				</tr>
				<tr>
					<th>회원이름</th>
					<td><input type="text" name="mem_name" value="${vo.mem_name }" class="form-control"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="mem_phone" class="form-control"
						value="${vo.mem_phone }" onkeyup="phonecheck()"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="text" name="mem_email" class="form-control"
						value="${vo.mem_email }" onkeyup="emailcheck()"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="mem_addr" value="${vo.mem_addr }" class="form-control"></td>
				</tr>
			</table>
				<div id="bnt" style="text-align: center">
					<input class="btn btn-primary" type="submit" value="저장">
					  <div id=remove style="text-align:right;">
					  <a href="${cp }/mem/memDelete.jsp" class="btn btn-sm">회원탈퇴 </a>
					  </div>
				</div>
			</form>
	</div>
	</div>
