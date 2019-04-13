function buyValidate() {
	var name = document.getElementById("name").value;
	var addr = document.getElementById("addr").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	
	var div = document.getElementById("msg");
	if(name == null || name == ""){
		document.getElementById("name").focus();
		div.innerHTML = "받으시는 분을 입력해주세요.";
		return false;
	}else if(addr == null || addr == ""){
		document.getElementById("addr").focus();
		div.innerHTML = "주소를 입력해주세요.";
		return false;
	}else if(phone == null || phone == ""){
		document.getElementById("phone").focus();
		div.innerHTML = "전화번호를 입력해주세요.";
		return false;
	}else if(email == null || email == ""){
		document.getElementById("email").focus();
		div.innerHTML = "이메일을 입력해주세요.";
		return false;
	}else{
		return true;
	}
}
function setShip(mem_name, mem_addr, mem_phone, mem_email) {
	var radio = document.getElementsByName("ship");
	
	var name = document.getElementById("name");
	var addr = document.getElementById("addr");
	var phone = document.getElementById("phone");
	var email = document.getElementById("email");

	if(radio[0].checked == true){
		name.value = mem_name;
		addr.value = mem_addr;
		phone.value = mem_phone;
		email.value = mem_email;
	}else if(radio[1].checked == true){
		name.value = "";
		addr.value = "";
		phone.value = "";
		email.value = "";
	}
}
function setPayHow() {
	var radio = document.getElementsByName("payhow");
	
	var noaccount = document.getElementById("noaccount");
	var accout = document.getElementById("account");
	var paymsg = document.getElementById("paymsg");
	if(radio[0].checked == true){
		noaccount.style.display = "block";
		accout.style.display = "none";
		paymsg.style.display = "none";
	}else if(radio[1].checked == true){
		noaccount.style.display = "none";
		accout.style.display = "block";
		paymsg.style.display = "none";
	}else if(radio[2].checked == true || radio[3].checked == true){
		noaccount.style.display = "none";
		accout.style.display = "none";
		paymsg.style.display = "block";
	}
}