<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content_wrap" style="padding-top: 5%; padding-bottom: 5%">
<div id="box" style="width: 40%; height: 50%; margin: auto;">
	<h4 style="font-weight: bold;">회원 정보수정</h4>
	<div id="mypage" style="text-align:right;">
	<a href="${cp }/mypage/home">MYPAGE 목록</a>
	</div>
	<form method="post" action="${cp }/mypage/myInfo.do"
		onsubmit="return validate();">
		<table class="table table-striped">
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mem_pwd"
					value="${vo.mem_pwd }" id="pwd" onkeyup="pwdcheck()">(영문소문자/숫자,
					8자~16자)</td>
			</tr> 
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="re_pwd" id="repwd"
					value="${vo.mem_pwd }" onkeyup="pwdcheck()"></td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input type="text" name="mem_name" value="${vo.mem_name }"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="mem_phone"
					value="${vo.mem_phone }" onkeyup="phonecheck()"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="mem_email"
					value="${vo.mem_email }" onkeyup="emailcheck()"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="mem_addr" value="${vo.mem_addr }"></td>
			</tr>
		</table>
			<div id="bnt" style="text-align: center">
				<input class="btn btn-primary" type="submit" value="저장">
				  <div id=remove style="text-align:right;">
				  <a href="${cp }/mem/memDelete.jsp">회원탈퇴 </a>
				  </div>
			</div>
		</form>
</div>
</div>
