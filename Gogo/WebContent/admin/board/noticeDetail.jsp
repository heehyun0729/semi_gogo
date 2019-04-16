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
          	<span class="mx-2 mb-0">/</span> <strong class="text-black">공지사항</strong>
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
	          	</div>
	          
	          	<table class="table table-bordered">
	          		<colgroup>
	          			<col width=25%;></col>
	          			<col width=25%;></col>
	          			<col width=25%;></col>
	          			<col width=25%;></col>
	          		</colgroup>
				 	<thead>
				 		
				 	</thead>
				 	<tbody>
				 		<tr>
				 			<td class="text-center">번호</td>
				 			<td class="text-center">${nvo.notice_num }</td>
				 			
				 			<td class="text-center">카테고리</td>
				 			<c:choose>
								<c:when test="${nvo.notice_cate=='0' }">
									<td class="text-center">공지사항</td>
								</c:when>
								<c:when test="${nvo.notice_cate=='1' }">
									<td class="text-center">이벤트</td>
								</c:when>
							</c:choose>
				 		</tr>
				 		<tr>
				 			<td class="text-center">작성일</td>
				 			<td class="text-center">${nvo.notice_wdate }</td>
				 			<td class="text-center">조회수</td>
				 			<td class="text-center">${nvo.notice_hit }</td>
				 		</tr>
				 		<tr>
				 			<td colspan="1" class="text-center">제목</td>
				 			<td colspan="3">${nvo.notice_title }</td>
				 		</tr>
				 		<tr>
				 			<td colspan="1" class="text-center">내용</td>
				 			<td colspan="3">${nvo.notice_content}</td>
				 		</tr>
				 		<c:if test="${!empty ilist }">
							<tr>
								<td colspan = "4">
									<c:forEach var = "vo" items = "${ilist }">
										<img src = "${cp }/upload/notice/${vo.img_saveImg}">
									</c:forEach>
								</td>
							</tr>
						</c:if>
				 	</tbody>
	          	</table>
	          	<div class="row text-center" style="width: 100%">
                    <div style="width: 50%; float:none; margin:0 auto" >
                    	<input type="button" class="btn btn-primary" value="목록" onclick="location.href='${cp }/board/noticeList.do?menu_num=${menu_num}&notice_num=${nvo.notice_num }'">
						<input type="button" class="btn btn-primary" value="수정" onclick="location.href='${cp }/board/noticeUpdate.do?menu_num=${menu_num}&notice_num=${nvo.notice_num }'">
						<input type="button" class="btn btn-primary" value="삭제" onclick="location.href='${cp }/board/noticeDelete.do?menu_num=${menu_num}&notice_num=${nvo.notice_num }'">
                    </div>
                 </div>
	      </div>
	 </div> 
</body>
</html>