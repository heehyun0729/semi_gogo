<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a> 
       	<c:if test="${menu_num > 0 }">
       		<span class="mx-2 mb-0">/</span> <strong class="text-black">${cate_name }</strong>
       	</c:if> 
       	<c:if test = "${!empty menu_num }">
       		<span class="mx-2 mb-0">/</span> <strong class="text-black">${menu_name }</strong>
       	</c:if>
       	 <span class="mx-2 mb-0">/</span> <strong class="text-black">${pvo.prod_name }</strong>
      </div>
    </div>
  </div>
</div>  

<div class="site-section">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
	    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
	      <ol class="carousel-indicators">
	      	<c:set var = "i" value = "1"/>
	      	<c:forEach var = "vo" items = "${ilist }">
	      		<c:choose>
		    		<c:when test="${i % 2 == 1 }">
		    			<li data-target="#carouselExampleIndicators" data-slide-to="${i }" class="active"></li>
		    		</c:when>
		    		<c:otherwise>
		    			<li data-target="#carouselExampleIndicators" data-slide-to="${i }"></li>
		    		</c:otherwise>
		    	</c:choose>
	      		<c:set var = "i" value = "${i + 1 }"/>
			</c:forEach>
		  </ol>
		  
		  <c:set var = "i" value = "1"/>
		  <div class="carousel-inner">
		    <c:forEach var = "vo" items = "${ilist }">
		    	<c:choose>
		    		<c:when test="${i % 2 == 1 }">
		    			<div class="carousel-item active">
		     				 <img class="d-block w-100" src="${cp }/upload/product/${vo.img_saveImg}" alt="First slide">
		    			</div>
		    		</c:when>
		    		<c:otherwise>
		    			<div class="carousel-item">
		     				 <img class="d-block w-100" src="${cp }/upload/product/${vo.img_saveImg}" alt="First slide">
		    			</div>
		    		</c:otherwise>
		    	</c:choose>
		    	<c:set var = "i" value = "${i + 1 }"/>
			</c:forEach>
		  </div>
		  
		  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
      </div>
      
<div class="col-md-6">
<form method="post">
	<input type = "hidden" name = "prod_num" value = "${pvo.prod_num }">
	<input type = "hidden" name = "op_num" value = "${opvo.op_num }">
	<h2 class="text-black">${pvo.prod_name }</h2>
	<p><strong class="text-primary h4" id="price">${pvo.prod_price}원</strong></p>
	<div>
		<strong class="text-block">${opvo.op_name}</strong>
		<select class="form-control col-sm-7" id='option' onchange="addOp(this.selectedIndex)">
			<option value='' selected>-[필수] 옵션을 선택해주세요-</option>
		  	<c:forEach var = "vo1" items = "${doplist }">
		  		<option id="${vo1.detailOp_name}" value="${vo1.detailOp_num }">${vo1.detailOp_name}/${vo1.detailOp_price}</option>
		  	</c:forEach>
		</select>
		<div id="op"></div>
		<br>
		<span class="text-black">TOTAL: </span><div id="total" class="text-primary h4" style="display: inline-block;">0</div><span class="text-black">원</span>
	</div>
	<input type="submit" value="바로 구매하기" onclick="javascript: form.action = '${cp}/order/buyInsert?select=one';">
	<input type="submit" value="장바구니 담기" onclick="javascript: form.action = '${cp}/order/basketInsert.do';">
	<input type="button" value="관심상품 담기" onclick="location.href='${cp }/mypage/interInsert.do?prod_num=${pvo.prod_num }'">
</form>
</div>
     
        <div class="mb-5">
          <div class="input-group mb-3" style="max-width: 120px;">
          <div class="input-group-prepend">
            <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
          </div>
          <input type="text" class="form-control text-center" value="1" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
          <div class="input-group-append">
            <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
          </div>
        </div>

        </div>
        <p><a href="cart.html" class="buy-now btn btn-sm btn-primary">Add To Cart</a></p>

      </div>
    </div>
  </div>
 


 
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
//		parent.firstChild.removeChild(child); ////////////부모의 자식의 자식을 삭제할 것.
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