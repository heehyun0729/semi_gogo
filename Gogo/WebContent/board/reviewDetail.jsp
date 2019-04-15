<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "board">
	<h1>REVIEW</h1>
	<h3>�ı�</h3>
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
					[�ɼ�: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
				</c:if>
			</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${vo.review_title }</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${vo.mem_id }</td>
		</tr>
		<tr>
			<td colspan = "2">${vo.review_wdate } | <img src = "${cp }/images/star${vo.review_star }.png" style = "width: 100px"></td>
		</tr>
		<tr>
			<td>����</td>
			<td>${vo.review_content }</td>
		</tr>
		<c:if test="${!empty ilist }">
			<tr>
				<td>÷������</td>
				<td>
					<c:forEach var = "ivo" items = "${ilist }">
						<img src = "${cp }/upload/review/${ivo.img_saveImg}" style="width: 100px; height: 100px;">
					</c:forEach>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan = "2">��õ <span id = "like" style = "color: pink;">(${vo.review_like })</span>
			<input type = "button" value = "��õ" onclick="setLike('${cp}', '${vo.review_num }')"></td>
		</tr>
	</table>
	<a href = "javascript:history.go(-1)">���</a>
	<c:if test="${sessionScope.mem_id == vo.mem_id }">
		<a href = "${cp }/board/reviewUpdate?menu_num=${menu_num}&review_num=${vo.review_num}">����</a>
		<a href = "${cp }/board/reviewDelete?menu_num=${menu_num}&review_num=${vo.review_num}">����</a>
	</c:if>
</div>