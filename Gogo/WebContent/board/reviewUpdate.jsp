<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>REVIEW</h1>
	<h3>후기</h3>
	<form method="post" action="${cp }/board/reviewUpdate" enctype="multipart/form-data">
		<input type = "hidden" name = "review_num" value = "${review_num }">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<table border = "1" style = "width: 500px;">
			<tr>
				<td>구매한 상품</td>
				<td>
					${vo.prod_name } [옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type = "text" name = "title" value = "${vo.review_title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows = "5" cols = "50" name = "content">${vo.review_content }</textarea></td>
			</tr>
			<tr>
				<td>별점</td>
				<td>
					<fieldset class="rating">
					    <input type="radio" id="star5" name="star" value="5" 
						    <c:if test = "${vo.review_star == 5 }">
								checked == "checked"
							</c:if>/><label class = "full" for="star5"></label>
					    <input type="radio" id="star4" name="star" value="4" 
						    <c:if test = "${vo.review_star == 4 }">
								checked == "checked"
							</c:if>
						/><label class = "full" for="star4"></label>
					    <input type="radio" id="star3" name="star" value="3" 
						    <c:if test = "${vo.review_star == 3 }">
								checked == "checked"
							</c:if>/><label class = "full" for="star3"></label>
					    <input type="radio" id="star2" name="star" value="2" 
						    <c:if test = "${vo.review_star == 2 }">
								checked == "checked"
							</c:if>/><label class = "full" for="star2"></label>
					    <input type="radio" id="star1" name="star" value="1" 
						    <c:if test = "${vo.review_star == 1 }">
								checked == "checked"
							</c:if>/><label class = "full" for="star1"></label>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td>첨부파일1</td>
				<td><input type = "file" name = "file1"></td>
			</tr>
			<tr>
				<td>첨부파일2</td>
				<td><input type = "file" name = "file2"></td>
			</tr>
			<tr>
				<td>첨부파일3</td>
				<td><input type = "file" name = "file3"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "수정">
					<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
</div>