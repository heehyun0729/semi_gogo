function validate() {
	var id = document.getElementById("id").value;
	var pwd = document.getElementById("pwd").value;
	var repwd = document.getElementById("repwd").value;
	var name = document.getElementById("name").value;
	var phonetext = document.getElementById("phonetext").value;
	var email = document.getElementById("email").value;
	var addr = document.getElementById("addr").value;
	var div = document.getElementById("msg");
	
	if(id == null || id == ""){
		document.getElementById("id").focus();
		div.innerHTML = "아이디를 입력해주세요."
		return false;
	}else if(pwd == null || pwd == ""){
		document.getElementById("pwd").focus();
		div.innerHTML = "비밀번호를 입력해주세요."
		return false;
	}else if(repwd == null || repwd == ""){
		document.getElementById("repwd").focus();
		div.innerHTML = "비밀번호 확인문자를 입력해주세요."
		return false;
	}else if(name == null || name == ""){
		document.getElementById("name").focus();
		div.innerHTML = "이름을 입력해주세요."
		return false;
	}else if(phonetext == null || phonetext == ""){
		document.getElementById("phonetext").focus();
		div.innerHTML = "전화번호를 입력해주세요."
		return false;
	}else if(email == null || email == ""){
		document.getElementById("email").focus();
		div.innerHTML = "이메일을 입력해주세요."
		return false;
	}else if(addr == null || addr == ""){
		document.getElementById("addr").focus();
		div.innerHTML = "주소를 입력해주세요."
		return false;
	}else{
		return true;
	}
}

var xhr = null;
function idcheck(cp) {
	var id = document.getElementById("id").value;
	
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = idcheckOk;

	xhr.open('post', cp + '/mem/idcheck.jsp', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	var param = "id=" + id;
	xhr.send(param);
}
function idcheckOk() {
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		var json = eval("(" + data + ")");
		var msg = json.msg;
		var div = document.getElementById("idcheck");
		div.innerHTML = msg;
	}
}

function pwdcheck() {
	var pwd = document.getElementById("pwd").value;
	var repwd = document.getElementById("repwd").value;
	var div = document.getElementById("pwdcheck");	
	var check = true;
	var msg = "";
	if(pwd != repwd){
		check = false;
		msg = "비밀번호 확인문자가 일치하지 않습니다.";
	}
	for(var i = 0 ; i < pwd.length ; i++){
		var ch = pwd.charAt(i);
		if(!(ch >= 'a' && ch <= 'z') && !(ch >= '0' && ch <= '9')){
			check = false;
			msg = "비밀번호는 영문 소문자와 숫자로만 이루어져야 합니다.";
		}
	}
	if(pwd.length < 8 || pwd.length > 16){
		check = false;
		msg = "비밀번호는 8~16자 사이여야 합니다.";
	}
	if(check){
		msg = "";
	}
	div.innerHTML = msg;
}

function namecheck() {
	var name = document.getElementById("name").value;
	var div = document.getElementById("namecheck");
	var check = true;
	var msg = "";
	if(name.indexOf(" ") != -1){
		check = false;
		msg = "이름은 공백 없이 입력해야 합니다.";
	}
	for(var i = 0 ; i < name.length ; i++){
		var ch = name.charAt(i);
		if(!(ch >= 'a' && ch <= 'z')){
			if(name.length > 7){
				check = false;
				msg = "이름이 너무 깁니다.";
			}
		}else{
			if(name.length > 15){
				check = false;
				msg = "이름이 너무 깁니다.";
			}
		}
	}
	if(check){
		msg = "";
	}
	div.innerHTML = msg;
}

function phonecheck() {
	var phone = document.getElementById("phonetext").value;
	var div = document.getElementById("phonecheck");
	var check = true;
	var msg = "";
	if(phone.length > 15){
		check = false;
		msg = "전화번호가 너무 깁니다.";
	}
	for(var i = 0 ; i < phone.length ; i++){
		var ch = phone.charAt(i);
		if(!(ch >= '0' && ch <= '9')){
			check = false;
			msg = "전화번호는 숫자로만 이루어져야 합니다.";
		}
	}
	if(check){
		msg = "";
	}
	div.innerHTML = msg;
}

function emailcheck() {
	var email = document.getElementById("email").value;
	var div = document.getElementById("emailcheck");
	var check = true;
	var msg = "";
	if(email.length > 25){
		check = false;
		msg = "이메일이 너무 깁니다.";
	}
	if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
		check = false;
		msg = "이메일 형식을 확인해주세요.";
	}
	if(check){
		msg = "";
	}
	div.innerHTML = msg;
}

function addrcheck() {
	var addr = document.getElementById("addr").value;
	var div = document.getElementById("addrcheck");
	var check = true;
	var msg = "";
	for(var i = 0 ; i < addr.length ; i++){
		var ch = addr.charAt(i);
		if(!(ch >= 'a' && ch <= 'z')){
			if(addr.length > 180){
				check = false;
				msg = "주소가 너무 깁니다.";
			}
		}else{
			if(addr.length > 70){
				check = false;
				msg = "주소가 너무 깁니다.";
			}
		}
	}
	if(check){
		msg = "";
	}
	div.innerHTML = msg;
}

