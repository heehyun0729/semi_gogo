function basketCntUp(cntId){
	var cnt=document.getElementById(cntId);
	var cnt_value=parseInt(document.getElementById(cntId).value);
	
	cnt_value+=1;
	cnt.value=cnt_value;
}
function basketCntDown(cntId){
	var cnt=document.getElementById(cntId);
	var cnt_value=parseInt(document.getElementById(cntId).value);
	
	if(cnt_value<=1){
		alert("수량은 1개 이상이어야 합니다.");
	}else{
		cnt_value-=1;
		cnt.value=cnt_value;
	}
}
function changeCnt(cp, cntId, num) {
	var cnt = document.getElementById(cntId).value;
	location.href = cp + "/order/basketUpdate.do?basket_num=" + num + "&cnt=" + cnt;
}