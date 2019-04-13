function checkAll() {
	var ckAll = document.getElementById("ckAll");
	var check = document.getElementsByName("check");
	
	if(ckAll.checked == true){
		for(var i = 0 ; i < check.length ; i++){
			check[i].checked = true;
		}
	}else if(ckAll.checked == false){
		for(var i = 0 ; i < check.length ; i++){
			check[i].checked = false;
		}
	}
}
function isChecked() {
	var ckAll = document.getElementById("ckAll");
	var check = document.getElementsByName("check");
	
	var all = true;
	for(var i = 0 ; i < check.length ; i++){
		if(check[i].checked == false){
			ckAll.checked = false;
			all = false;
		}
	}
	if(all){
		ckAll.checked = true;
	}
}