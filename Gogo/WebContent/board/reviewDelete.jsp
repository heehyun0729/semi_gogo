<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">community</strong>
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">�ı�</strong>
         </div>
       </div>
     </div>
   </div>	
   
 <div class="site-section">
<div class="container">
	<div class="row">
		  <div class="col-md-12 mb-5">
               <div class="float-md-left mb-4"><h2 class="text-black h5">�ı�</h2></div>
             </div>
             
             <div class="row text-center" style="width: 100%">
                  <div style="width: 50%; float:none; margin:0 auto" >
                  	<div id = "board">
					<form method="post" action="${cp }/board/reviewDelete">
						<input type = "hidden" name = "menu_num" value = "${menu_num }">
						<input type = "hidden" name = "qna_num" value = "${review_num }">
						<p>���� ������ �����ұ��?</p>
						<input type = "submit" class="btn btn-primary" value = "����">
						<input type = "button" class="btn btn-primary" value = "���" onclick="javascript:history.go(-1);">
					</form>
				</div>
                  </div>
                </div>
                
        </div>
    </div>
  </div>