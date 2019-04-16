<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
	<body>
	
		<div class="bg-light py-3">
	      <div class="container">
	        <div class="row">
	          <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">COMMUNITY</strong>
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의</strong>
	          </div>
	        </div>
	      </div>
	    </div>	
	    
	    <div class="site-section">
			<div class="container">
				<div class="row">
					  <div class="col-md-12 mb-5">
		                <div class="float-md-left mb-4"><h2 class="text-black h5">문의</h2></div>
		              </div>
		              
		              <div class="row text-center" style="width: 100%;margin-top:50px;">
	                    <div style="width: 30%; float:none; margin:0 auto" >
	                     <div id = "board">
							<form method="post" action = "${cp }/board/qnaDetail">
								<input type = "hidden" name = "menu_num" value = "${menu_num }">
								<input type = "hidden" name = "qna_num" value = "${qna_num }">
								<h3>비밀번호 입력</h3>
								<input type = "password" name = "pwd"><br>
								<br/>
								<div style="color: red; font-size: 12px;">${msg }</div>
								<br/>
								<input type = "submit" class="btn btn-primary" value = "확인">
								<input type = "button" class="btn btn-primary" value = "취소" onclick = "javascript:history.go(-1)">
							</form>
						</div>
	                    </div>
                      </div>
		              
		         </div>
		     </div>
		</div>
	    
	    
	</body>
</html>
