<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>REVIEW</h1>
	<h3>후기</h3>
	<br>
	<table border = "1" style="width: 500px;">
		<tr>
			<td>
				<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
					<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px;height: 100px;">
				</a>
			</td>
			<td>
				<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">${vo.prod_name }</a>
				<c:if test="${vo.prod_name != vo.op_name }">
					[옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
				</c:if>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${vo.review_title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.mem_id }</td>
		</tr>
		<tr>
			<td colspan = "2">${vo.review_wdate } | ${vo.review_star }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${vo.review_content }</td>
		</tr>
		<c:if test="${!empty ilist }">
			<tr>
				<td>첨부파일</td>
				<td>
					<c:forEach var = "ivo" items = "${ilist }">
						<img src = "${cp }/upload/review/${ivo.img_saveImg}" style="width: 100px; height: 100px;">
					</c:forEach>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan = "2">추천 <span id = "like" style = "color: pink;">(${vo.review_like })</span>
			<input type = "button" value = "추천" onclick="setLike('${cp}', '${vo.review_num }')"></td>
		</tr>
	</table>
</div>