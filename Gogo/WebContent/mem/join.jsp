<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "board">
	<h2>회원가입</h2>
		<form method="post" action="${cp }/mem/join" onsubmit="return validate();">
			<table border = "1">
				<tr>
					<td><input type="hidden" name="mem_num" id="num"></td>
				</tr>
				<tr>
					<th>아이디 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><input type="text" name="mem_id" id = "id" onkeyup = "idcheck('${cp}')">(영문 소문자/숫자, 4~15자)</td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "idcheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
				<tr>
					<th>비밀번호  <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><input type="password" name="mem_pwd" id = "pwd" onkeyup = "pwdcheck()">(영문 소문자/숫자, 8자~16자)</td>
				</tr>
				<tr>
					<th>비밀번호 확인 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><input type="password" name="repwd" id = "repwd" onkeyup = "pwdcheck()"></td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "pwdcheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
				<tr>
					<th>이름 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><input type="text" name="mem_name" id = "name" onkeyup = "namecheck()"></td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "namecheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
				<tr>
					<th>전화번호<img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td>
						<select name="mem_phone" id="phone" size="1">
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="070">070</option>
							<option value="010">010</option>
							<option value="011">011</option>
						</select>
						<input type="text" name="phonetext" id = "phonetext" onkeyup = "phonecheck()">(- 없이 입력)
					</td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "phonecheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
				<tr>
					<th>이메일 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><input type="text" name="mem_email" id = "email" onkeyup = "emailcheck()"></td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "emailcheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
				<tr>
					<th>주소 <img src="//img.echosting.cafe24.com/skin/base/common/ico_required.gif" alt="필수"></th>
					<td><textarea rows="3" cols="50" name="mem_addr" id = "addr" onkeyup = "addrcheck()"></textarea></td>
				</tr>
				<tr>
					<td colspan = "2"><div id = "addrcheck" style="color: red; font-size: 12px;"></div><td>
				</tr>
			</table>
			<div id = "msg" style="color: red; font-size: 12px;"></div>
			<input  TYPE="submit" value="가입">
		</form>
</div>