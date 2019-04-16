<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       	<span class="mx-2 mb-0">/</span><a href="${cp }/mypage/home">mypage</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">회원탈퇴</strong>
       </div>
     </div>
   </div>
 </div>	
 <div class="site-section">
<div class="container">
	<div class="row">
		  <div class="col-md-12 mb-5">
               <div class="float-md-left mb-4"><h2 class="text-black h5">회원탈퇴</h2></div>
             </div>
             
             <div class="row text-center" style="width: 100%">
                  <div style="width: 50%; float:none; margin:0 auto" >
                  	<div id = "board">
					<form method="post" action="${cp }/mem/delete.do">
						<input type = "hidden" name = "menu_num" value = "${menu_num }">
						<input type = "hidden" name = "qna_num" value = "${qna_num }">
						<h3>회원탈퇴</h3>
						<p>비밀번호 입력</p>
						<div style = "width: 40%; margin-left: 30%; margin-right: 30%;">
						<input type="password" name="mem_pwd" class="form-control"> 
						</div>
						<br>
						<input type="submit" class="btn btn-sm btn-primary" value="탈퇴"> 
						<input type = "button" class="btn btn-sm btn-outline-primary" value = "취소" onclick="javascript:history.go(-1);">
					</form>
				</div>
                  </div>
                </div>
                
        </div>
    </div>
  </div>