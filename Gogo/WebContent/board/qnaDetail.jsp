<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의</strong>
	          </div>
	        </div>
	      </div>
	    </div>
	    
	    <div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-5">
		                <div class="float-md-left mb-4"><h2 class="text-black h5">공지사항</h2></div>
	          		</div>
	          		<table class="table table-bordered">
		          		<colgroup>
		          			<col width=25%;></col>
		          			<col width=25%;></col>
		          		</colgroup>
					 	<thead>
					 		
					 	</thead>
					 	<tbody>
					 		<tr class="text-center">
					 			<td>제목</td>
								<td>${qvo.qna_title }</td>
					 		</tr>
					 		<tr class="text-center">
								<td>작성자</td>
								<td>${qvo.mem_id }</td>
					 		</tr>
					 		<tr class="text-center">
								<td>작성일</td>
								<td>${qvo.qna_wdate }</td>
					 		</tr>
					 		<tr>
					 			<td colspan = "2"><textarea style="width:100%;" rows = "10" cols = "80" readonly="readonly">${qvo.qna_content }</textarea></td>
					 		</tr>
					 		<c:if test="${!empty ilist }">
								<tr>
									<td colspan = "2">
										<c:forEach var = "vo" items = "${ilist }">
											<img src = "${cp }/upload/qna/${vo.img_saveImg}" style = "width: 100px; height: 100px;">
										</c:forEach>
									</td>
								</tr>
							</c:if>
					 	</tbody>
	          		</table>
	          		
	          		<div class="row text-center" style="width: 100%;margin-top:50px;">
	                    <div style="width: 30%; float:none; margin:0 auto" >
	                    	<a class="btn btn-primary" href = "javascript:history.go(-2)">목록</a>
							<c:if test="${sessionScope.mem_id == qvo.mem_id }">
								<a class="btn btn-primary" href = "${cp }/board/qnaUpdate?menu_num=${menu_num}&qna_num=${qvo.qna_num}">수정</a>
								<a class="btn btn-primary" href = "${cp }/board/qnaDelete?menu_num=${menu_num}&qna_num=${qvo.qna_num}">삭제</a>
							</c:if>
							<c:if test="${sessionScope.mem_id == 'admin'}">
								<a class="btn btn-primary" href = "${cp }/board/qnaInsert?menu_num=${menu_num}&qna_num=${qvo.qna_num}">답글</a>
							</c:if>
	                    </div>
                    </div>
	          		
	          	</div>
		    </div>
		</div>
	          	
	    
	</body>
</html>