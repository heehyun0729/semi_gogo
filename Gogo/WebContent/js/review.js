var xhr = null;
function setLike(cp, num) {
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = setLikeOk;
	xhr.open('get', cp + '/board/setLike.jsp?review_num=' + num, true);
	xhr.send();
}
function setLikeOk() {
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		var json = eval("(" + data + ")");
		var span = document.getElementById("like");
		span.innerHTML = json.review_like;
	}
}