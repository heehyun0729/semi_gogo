<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content_wrap" style="padding-top: 5%; padding-bottom: 5%">
	<div id="box" style="width: 40%; height: 50%; margin: auto;">
		<h2 style="text-align: center; font-weight: bold;">회원가입</h2>
		<br>
		<div id="input" style="width: 50%; margin: auto;">
			<form method="post" action="${cp }/mem/join"
				onsubmit="return validate();">
				<input class="form-control" type="hidden" name="mem_num" id="num">
				<label for="mem_id" style="color: black; font-weight: bold;">아이디</label>
				<span><input class="form-control" type="text" name="mem_id"
					id="id" placeholder="아이디" onkeyup="idcheck('${cp}')">
					(영문소문자/숫자, 4~15자)</span>
				<div id="idcheck" style="color: red; font-size: 12px;"></div>
				<br> <label for="pwd" style="color: black; font-weight: bold;">비밀번호</label>
				<span><input class="form-control" type="password"
					name="mem_pwd" id="pwd" placeholder="비밀번호" onkeyup="pwdcheck()"></span>
					(영문소문자/숫자, 8자~16자) <span><input class="form-control"
					type="password" name="repwd" id="repwd" placeholder="비밀번호 재확인"
					onkeyup="pwdcheck()"></span>
				<div id="pwdcheck" style="color: red; font-size: 12px;"></div>
				<label for="name" style="color: black; font-weight: bold;">이름</label>
				<input class="form-control" type="text" name="mem_name" id="name"
					placeholder="이름" onkeyup="namecheck()"><br>
				<div id="namecheck" style="color: red; font-size: 12px;"></div>
				<label for="mem_phone" style="color: black; font-weight: bold;">전화번호</label>
				<select class="form-control" name="mem_phone" id="phone" size="1">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="070">070</option>
					<option value="010">010</option>
					<option value="011">011</option>
				</select> <input class="form-control" placeholder="전화번호" type="text"
					name="phonetext" id="phonetext" onkeyup="phonecheck()">
					( 'ㅡ ' 없이 입력)
				<div id="phonecheck" style="color: red; font-size: 12px;"></div>
				<label for="name" style="color: black; font-weight: bold;">이메일</label>
				<input class="form-control" type="text" name="mem_email"
					placeholder="이메일" id="email" onkeyup="emailcheck()">
				<div id="emailcheck" style="color: red; font-size: 12px;"></div>
				<br> <label for="mem_addr"
					style="color: black; font-weight: bold;">주소</label>
				<textarea class="form-control" rows="3" cols="50" placeholder="주소"
					name="mem_addr" id="addr" onkeyup="addrcheck()"></textarea>
				<div id="addrcheck" style="color: red; font-size: 12px;"></div>
				<br>
				<div id="msg" style="color: red; font-size: 12px;"></div>
				<div id="button" style="text-align: center">
					<input class="btn btn-primary signup" type="submit" value="가입">
				</div>
			</form>
		</div>
	</div>
</div>