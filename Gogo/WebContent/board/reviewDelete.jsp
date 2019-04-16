<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">community</strong>
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">후기</strong>
         </div>
       </div>
     </div>
   </div>	
   
 <div class="site-section">
<div class="container">
	<div class="row">
		  <div class="col-md-12 mb-5">
               <div class="float-md-left mb-4"><h2 class="text-black h5">후기</h2></div>
             </div>
             
             <div class="row text-center" style="width: 100%">
                  <div style="width: 50%; float:none; margin:0 auto" >
                  	<div id = "board">
					<form method="post" action="${cp }/board/reviewDelete">
						<input type = "hidden" name = "menu_num" value = "${menu_num }">
						<input type = "hidden" name = "review_num" value = "${review_num }">
						<h3>글을 정말로 삭제할까요?</h3>
							<br>
						<input type = "submit" class="btn btn-sm btn-primary" value = "삭제">
						<input type = "button" class="btn btn-sm btn-outline-primary" value = "취소" onclick="javascript:history.go(-1);">
					</form>
				</div>
                  </div>
                </div>
                
        </div>
    </div>
  </div>