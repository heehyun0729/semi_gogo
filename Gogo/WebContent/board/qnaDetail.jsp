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
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">COMMUNITY</strong>
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의</strong>
	          </div>
	        </div>
	      </div>
	    </div>
	    
	    <div class="site-section">
			<div class="container">
				<div class="row ">
					<div class="col-md-12 mb-5">
		                <div class="float-md-left mb-4"><h2 class="text-black h5">문의</h2></div>
	          		</div>
	          		<table class="table table-bordered">
		          		<colgroup>
		          			<col width=25%;></col>
		          			<col width=25%;></col>
		          			<col width=25%;></col>
		          			<col width=25%;></col>
		          		</colgroup>
					 	<tbody>
					 		<tr class="text-center">
					 			<td class = "text-primary">번호</td>
								<td>${qvo.qna_num }</td>
								<td class = "text-primary">카테고리</td>
								<td>
									<c:choose>
										<c:when test="${qvo.qna_cate == 'prod' }">
											상품
										</c:when>
										<c:when test="${qvo.qna_cate == 'ship' }">
											배송
										</c:when>
										<c:when test="${qvo.qna_cate == 'cancel' }">
											교환/반품
										</c:when>
										<c:when test="${qvo.qna_cate == 'pay' }">
											결제
										</c:when>
										<c:when test="${qvo.qna_cate == 'etc' }">
											기타
										</c:when>
									</c:choose>
								</td>
					 		</tr>
					 		<tr class="text-center">
								<td class = "text-primary">작성자</td>
								<td>${qvo.mem_id }</td>
								<td class = "text-primary">작성일</td>
								<td>${qvo.qna_wdate }</td>
					 		</tr>
					 		<tr class="text-center">
					 			<td colspan="1" class = "text-primary">제목</td>
								<td colspan="3">${qvo.qna_title }</td>
							</tr>
					 		<tr class="text-center">
					 			<td colspan="1" class="text-primary">내용</td>
					 			<td colspan = "3">${qvo.qna_content }</td>
					 		</tr>
					 		<c:if test="${!empty ilist }">
								<tr class="text-center">
									<td colspan = "4">
										<c:forEach var = "vo" items = "${ilist }">
											<img src = "${cp }/upload/qna/${vo.img_saveImg}" class="img-fluid" style="max-width: 500px;">
										</c:forEach>
									</td>
								</tr>
							</c:if>
					 	</tbody>
	          		</table>
	          		<div class="row text-center" style="width: 100%;margin-top:50px;">
	                    <div style="width: 30%; float:none; margin:0 auto" >
	                    	<c:choose>
	                    		<c:when test="${sessionScope.mem_id == 'admin' }">
	                    			<a class="btn btn-primary" href = "javascript:history.go(-1)">목록</a>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<a class="btn btn-primary" href = "javascript:history.go(-2)">목록</a>
	                    		</c:otherwise>
	                    	</c:choose>
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