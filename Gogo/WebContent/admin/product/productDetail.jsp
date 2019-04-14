<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="board">

	<div>
		<h1>상품 상세보기</h1>
	</div>
	
	<div id="printArea">
		<img src="${cp }/upload/product/${ilist.get(0).getImg_saveImg() }" id="img1" style="border:1px; width:300px;height:400px; float:left;">
	</div>
	
	<div>
		<table>
			<tr>
				<c:forEach var = "vo" items = "${ilist }">
					<td colspan = "1">
						<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px; height: 100px;" onmouseover="printImg(this.src)">
					</td>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>

<form method="post">
	<input type = "hidden" name = "prod_num" value = "${pvo.prod_num }">
	<input type = "hidden" name = "op_num" value = "${opvo.op_num }">
	<div>
		<table>
			<tr>
				<td>${pvo.prod_name }</td><td><span id="price">${pvo.prod_price}</span></td>
			</tr>
			<tr>
				<td>${opvo.op_name}</td>
				<td>
					<select id='option' onchange="addOp(this.selectedIndex)">
						<option value='' selected>-[필수] 옵션을 선택해주세요-</option>
					  	<c:forEach var = "vo1" items = "${doplist }">
					  		<option id="${vo1.detailOp_name}" value="${vo1.detailOp_num }">${vo1.detailOp_name}/${vo1.detailOp_price}</option>
					  	</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<div id="op"></div>
		<div id="total">0</div>
	</div>
		<input type="submit" value="바로 구매하기" onclick="javascript: form.action = '${cp}/order/buyInsert?select=one';">
		<input type="submit" value="장바구니 담기" onclick="javascript: form.action = '${cp}/order/basketInsert.do';">
		<input type="button" value="관심상품 담기" onclick="location.href='${cp }/mypage/interInsert.do?prod_num=${pvo.prod_num }'">
</form>
<script type="text/javascript">
	var total=document.getElementById("total");
	var total_value=parseInt(total.innerHTML);
	var plusAmount=null;
	var num=0;
	function printImg(value){
		var img1=document.getElementById("img1");
		img1.src=value;
	}
	function addOp(index){
		var opt=document.getElementById("option").options[index];
		var value = opt.value;
		document.getElementById("option").selectedIndex=0;
		var opt_value=opt.text.split('/',2);
		var opt_menu=opt_value[0];
		var opt_price=parseInt(opt_value[1]);
		if(opt.value!=0){
			var divOp = document.getElementById("op");
			var divli=document.createElement("div");
			divli.innerHTML = "<div id='addOp" + num + "'>옵션추가:"+opt_menu+"/"+opt_price+
			"<div>수량추가:<input type='button' value='▲' onclick='cntUp(this.parentNode.nextSibling.id,this.nextSibling.id)'>"+
			"<input type='text' name = 'basket_cnt' id='amount"+num+"' value='1' readonly='readonly' style='width: 20px;'>"+
			"<input type='button' value='▼' onclick='cntDown(this.parentNode.nextSibling.id,this.previousSibling.id)'></div>"+
			"<div id='optotal"+num+"'>${pvo.prod_price }</div>"+
			"<input type='button' value='삭제' onclick='delOp(this.parentNode.id)'></div>"+
			"<input type = 'hidden' name = 'detailOp_num' value = '" + value + "'>";
			divOp.appendChild(divli);
			var optotal=document.getElementById("optotal"+num);
			optotal_value=parseInt(optotal.innerHTML);
			optotal_value+=opt_price;
			optotal.innerHTML=optotal_value;
			plusAmount=optotal_value;
			
			total_value=parseInt(total.innerHTML);
			total_value+=optotal_value;
			total.innerHTML=total_value;
			
			opt.value=0;
			num++;
			console.log(num);
		}
	}
	function delOp(value){
		console.log("value:"+value);
		//li 삭제
		var parent = document.getElementById("op");
		//삭제될 li
		var child = document.getElementById(value);
		console.log("child:"+child.id);
		//옵션 총 가격 div
		var optotaldiv=child.firstChild.nextSibling.nextSibling.innerHTML;
		
		var li_tresh=child.firstChild.nodeValue;
		var li_value=li_tresh.split(':',2);
		var li_type=li_value[1].split('/',2);
		//삭제를 누른 옵션 얻어오기
		var opt=document.getElementById(li_type[0]);
		var opt_value=opt.text.split('/',2);
		var opt_menu=opt_value[0];//옵션타입
		var opt_price=parseInt(opt_value[1]);//가격
		
		opt.value=1;
		parent.removeChild(child.parentNode);
		
		total_value=parseInt(total.innerHTML);
		total_value-=optotaldiv;
		total.innerHTML=total_value;
	}
	function cntUp(value,amountId){
	
		var price=document.getElementById("price");
		var price_value=parseInt(price.innerText);
		var optotaldiv=document.getElementById(value);
		var optotaldiv_value=parseInt(optotaldiv.innerHTML);
		var amount=document.getElementById(amountId);
		var amount_value=parseInt(document.getElementById(amountId).value);
		
		amount_value++;
		amount.value=amount_value;
		
		optotaldiv.innerHTML=optotaldiv_value+plusAmount;
		console.log("optotaldiv_value : "+optotaldiv_value);
		
		total_value+=plusAmount;
		total.innerHTML=total_value;
		console.log("plusAmount : "+plusAmount);
		
	}
	function cntDown(value,amountId){
		var price=document.getElementById("price");
		var price_value=parseInt(price.innerText);
		var optotaldiv=document.getElementById(value);
		var optotaldiv_value=parseInt(optotaldiv.innerHTML);
		var amount=document.getElementById(amountId);
		var amount_value=parseInt(document.getElementById(amountId).value);
		
		if(amount_value<=1){
			alert("수량은 1개 이상이어야 합니다.");
		}else{
			amount_value-=1;
			amount.value=amount_value;
			
			optotaldiv.innerHTML=optotaldiv_value-plusAmount;
			
			total_value-=plusAmount;
			total.innerHTML=total_value;
		}
	}
</script>
<br>
<div>
	<c:forEach var = "divo" items = "${dilist }">
		<img src = "${cp }/upload/product/${divo.img_saveImg}" style = "width: 200px; height: 200px;">
	</c:forEach>
</div>
<div>
	<input type="button" value="목록" onclick="location.href='${cp }/product/productList.do?menu_num=${menu_num}&prod_num=${pvo.prod_num }'">
	<input type="button" value="수정" onclick="location.href='${cp }/admin/product/productUpdate?menu_num=${menu_num}&prod_num=${pvo.prod_num }'">
	<input type="button" value="삭제" onclick="location.href='${cp }/admin/product/productDelete?menu_num=${menu_num}&prod_num=${pvo.prod_num }'">
</div>