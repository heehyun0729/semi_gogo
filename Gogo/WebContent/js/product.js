function prodValidate() {
	var cate = document.getElementsByName("cate")[0].value;
	var name = document.getElementsByName("name")[0].value;
	var price = document.getElementsByName("price")[0].value;
	
	var div = document.getElementById("msg");
	if(cate == null || cate == ""){
		div.innerHTML = "카테고리를 선택해주세요.";
		return false;
	}else if(name == null || name == ""){
		document.getElementsByName("name")[0].focus();
		div.innerHTML = "상품명을 입력해주세요.";
		return false;
	}else if(price == null || price == ""){
		document.getElementsByName("price")[0].focus();
		div.innerHTML = "가격을 입력해주세요.";
		return false;
	}else{
		return true;
	}
}

var xhr = null;
function getMenu(value, cp) {
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = getMenuOk;
	xhr.open('get', cp + '/admin/product/getMenu.jsp?cate_num=' + value, true);
	xhr.send();
}
function getMenuOk() {
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		var json = eval("(" + data + ")");
		var sel = document.getElementsByName("menu")[0];
		var chList = sel.childNodes;
		for(var i = (chList.length - 1) ; i >= 0 ; i--){
			var ch = chList.item(i);
			sel.removeChild(ch);
			
		}
		for(var i = 0 ; i < json.length ; i++){
			var menu_num = json[i].menu_num;
			var menu_name = json[i].menu_name;
			var option = document.createElement("option");
			option.setAttribute("value", menu_num);
			option.innerHTML = menu_name;
			sel.appendChild(option);
		}
	}
}
function addDivOp() {
	var btnAdd = document.getElementById("btnAdd");
	btnAdd.style.display = "none";
	var divOp = document.getElementById("op");
	divOp.innerHTML = "<input type = 'button' value = '옵션삭제' id = 'btnDel' onclick='delDivOp(this.parentNode.id)'><br>" + 
					"옵션명 <input type = 'text' name = 'op'> " +
					"<input type = 'button' value = '세부옵션추가' onclick='addDivDetailOp()'>" + 
					"<div id = 'detailOp1'>" +
						"세부옵션명 <input type = 'text' name = 'detailOp'><br>" +
						"추가가격 <input type = 'text' name = 'detailOpPrice'><br>" +
						"<input type = 'button' value = '세부옵션삭제' onclick='delDivDetailOp(this.parentNode.id)'>" + 
					"</div>";
}
var n = 2;
function addDivDetailOp() {
	var divOp = document.getElementById("op");
	var div = document.createElement("div");
	div.innerHTML = "<div id = 'detailOp" + n + "'>" +
					"세부옵션명 <input type = 'text' name = 'detailOp'><br>" +
					"추가가격 <input type = 'text' name = 'detailOpPrice'><br>" +
					"<input type = 'button' value = '세부옵션삭제' onclick='delDivDetailOp(this.parentNode.id)'>" +
					"</div>";
	divOp.appendChild(div);
	n++;
}
function delDivOp(value) {
	var btnAdd = document.getElementById("btnAdd");
	btnAdd.style.display = "inline";
	
	var parent = document.getElementById(value);
	var nodes = parent.childNodes;
	for(var i = (nodes.length - 1) ; i >= 0 ; i--){
		var child = nodes.item(i);
		parent.removeChild(child);
	}
}
function delDivDetailOp(value) {
	var parent = document.getElementById(value);
	var nodes = parent.childNodes;
	for(var i = (nodes.length - 1) ; i >= 0 ; i--){
		var child = nodes.item(i);
		parent.removeChild(child);
	}
}
function changeMenu(value, cp) {
	location.href = cp + "/product/productList.do?menu_num=" + value;
}