<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<div class="box" style="width:40%;height:50%;text-align:center;margin:auto;padding-top:5%;padding-bottom:5%;" >
		<h6>조회된 비밀번호는</h6>
		<div class="font" style="display:inline;">
			<input class="form-control" type="text" name="mem_pwd" value="${result}" style="width:15%;margin:auto;text-align:center;color:black;font-weight:bold;">입니다.
			</div><br><br>
			<a href="${cp }/mem/login">로그인페이지</a>
	</div>
</div>