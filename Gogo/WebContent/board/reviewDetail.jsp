<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<div class="row ">
			<div class="col-md-12 mb-5">
                <div class="float-md-left mb-4"><h2 class="text-black h5">후기</h2></div>
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
						<td>${vo.review_num }</td>
						<td class = "text-primary">작성일</td>
						<td>${vo.review_wdate }</td>
			 		</tr>
			 		<tr class="text-center">
						<td>
							<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">
								<img src = "${cp }/upload/product/${vo.img_saveImg}" style = "width: 100px;height: 100px;">
							</a>
						</td>
						<td colspan = "3">
							<a href = "${cp }/product/productDetail.do?menu_num=${vo.menu_num}&prod_num=${vo.prod_num}">${vo.prod_name }</a>
							<c:if test="${vo.prod_name != vo.op_name }">
								<br>[옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
							</c:if>
						</td>
			 		</tr>
			 		<tr class="text-center">
						<td class = "text-primary">작성자</td>
						<td>${vo.mem_id }</td>
						<td class = "text-primary">별점</td>
						<td><img src = "${cp }/images/star${vo.review_star }.png" style = "width: 100px"></td>
			 		</tr>
			 		<tr class="text-center">
			 			<td colspan="1" class = "text-primary">제목</td>
						<td colspan="3">${vo.review_title }</td>
					</tr>
			 		<tr class="text-center">
			 			<td colspan="1" class="text-primary">내용</td>
			 			<td colspan = "3">${vo.review_content }</td>
			 		</tr>
			 		<c:if test="${!empty ilist }">
						<tr class="text-center">
							<td colspan = "4">
								<c:forEach var = "vo" items = "${ilist }">
									<img src = "${cp }/upload/review/${vo.img_saveImg}" class="img-fluid" style="max-width: 500px;">
								</c:forEach>
							</td>
						</tr>
					</c:if>
					<tr class="text-center">
			 			<td colspan = "4">
			 				 <h3 id = "like" class = "text-primary">${vo.review_like }</h3>
							<a href = "javascript:setLike('${cp}', '${vo.review_num }')"><i class="far fa-thumbs-up" style = "font-size: 3em;"></i></a>
			 			</td>
			 		</tr>
			 	</tbody>
         		</table>
         		<div class="row text-center" style="width: 100%;margin-top:50px;">
                   <div style="width: 30%; float:none; margin:0 auto" >
                   		<a class="btn btn-sm btn-outline-primary" href = "javascript:history.go(-1)">목록</a>
					<c:if test="${sessionScope.mem_id == vo.mem_id }">
						<a class="btn btn-sm btn-primary" href = "${cp }/board/reviewUpdate?menu_num=${menu_num}&review_num=${vo.review_num}">수정</a>
						<a class="btn btn-sm btn-primary" href = "${cp }/board/reviewDelete?menu_num=${menu_num}&review_num=${vo.review_num}">삭제</a>
					</c:if>
                   </div>
                  </div>
         	</div>
    </div>
</div>