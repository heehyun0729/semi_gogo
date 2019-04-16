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
	          	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의 수정페이지</strong>
	          </div>
	        </div>
	      </div>
	    </div>
	    
	    <div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-5">
		                <div class="float-md-left mb-4"><h2 class="text-black h5">문의 수정페이지</h2></div>
		             </div>
		             <form method="post" action="${cp }/board/qnaUpdate" enctype="multipart/form-data">
						<input type = "hidden" name = "menu_num" value = "${menu_num }">
						<input type = "hidden" name = "qna_num" value = "${vo.qna_num }">
			             <table class="table table-bordered">
						 	<thead>
						 		
						 	</thead>
						 	<tbody>
						 		<tr>
									<td class="text-center">카테고리</td>
									<td>
										<select name = "cate" style="width:100%;">
											<option value = "prod"
												<c:if test = "${vo.qna_cate == 'prod'}">
													selected = "selected"
												</c:if>
											>상품</option>
											<option value = "ship"
												<c:if test = "${vo.qna_cate == 'ship'}">
													selected = "selected"
												</c:if>
											>배송</option>
											<option value = "cancel"
												<c:if test = "${vo.qna_cate == 'cancel'}">
													selected = "selected"
												</c:if>
											>교환/반품</option>
											<option value = "pay"
												<c:if test = "${vo.qna_cate == 'pay'}">
													selected = "selected"
												</c:if>
											>결제</option>
											<option value = "etc"
												<c:if test = "${vo.qna_cate == 'etc'}">
													selected = "selected"
												</c:if>
											>기타</option>
										</select>
									</td>
								</tr>
						 		<tr class="text-center">
						 			<td>제목</td>
									<td><input type="text" name = "title" style="width:100%;" value = "${vo.qna_title }"></td>
						 		</tr>
						 		<tr>
									<td colspan = "2"><textarea rows = "10" cols = "80" name = "content" style="width:100%;">${vo.qna_content }</textarea></td>
								</tr>
								<tr>
									<td class="text-center">첨부파일1</td>
									<td><input type = "file" name = "file1"></td>
								</tr>
								<tr>
									<td class="text-center">첨부파일2</td>
									<td><input type = "file" name = "file2"></td>
								</tr>
								<tr>
									<td class="text-center">첨부파일3</td>
									<td><input type = "file" name = "file3"></td>
								</tr>
								<tr class="text-center">
									<td class="text-center">비밀번호</td>
									<td><input type = "password" style="width:100%;" name = "pwd"></td>
								</tr>
								<tr class="text-center">
									<td colspan = "2">
										<input type = "submit" class="btn btn-primary" value = "수정">
										<input type = "button" class="btn btn-primary" value = "취소" onclick="javascript:history.go(-1)">
									</td>
								</tr>
						 	</tbody>
						</table>
					</form>
		         </div>
		     </div>
		 </div>
	    
	    
	</body>
</html>