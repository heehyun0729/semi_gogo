var xhr = null;
function getProd(cp) {
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = getProdOk;
	xhr.open('get', cp + '/board/getProd.jsp', true);
	xhr.send();
}
function getProdOk() {
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		
	}
}