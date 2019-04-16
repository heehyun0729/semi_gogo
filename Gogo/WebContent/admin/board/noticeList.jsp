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
	              <form name="cate" method="post">
						<select onchange="getCate(this.value)" class="form-control col-sm-12"> 
							<option value="">전체</option>
							<option value="0"
								<c:if test = "${cate == '0'}">
									selected = "selected"
								</c:if>
							>공지사항</option>
							<option value="1"
								<c:if test = "${cate == '1'}">
									selected = "selected"
								</c:if>
							>이벤트</option>
						</select>
				  </form>
				<br><br>
				<table class="table table-hover">
				 	<thead>
				 		<tr>
				 			<th class="text-center">번호</th>
				 			<th class="text-center">카테고리</th>
				 			<th class="text-center">제목</th>
				 			<th class="text-center">조회수</th>
				 		</tr>
				 	</thead>
				 	<tbody>
				 		<c:forEach var="vo" items="${list }">
							<c:choose>
								<c:when test="${vo.notice_step==0 }">
									<tr class="text-center">
										<td><strong class="text-black">${vo.notice_num }</strong></td>
										<c:choose>
											<c:when test="${vo.notice_cate==0 }">
												<td><strong class="text-black">공지사항</strong></td>
											</c:when>
											<c:when test="${vo.notice_cate==1 }">
												<td><strong class="text-black">이벤트</strong></td>
											</c:when>
										</c:choose>
										<td><strong><a class="text-primary" href = "${pageContext.request.contextPath }/board/noticeDetail.do?menu_num=${menu_num }&notice_num=${vo.notice_num}">${vo.notice_title }</a></strong></td>
										<td><strong class="text-black">${vo.notice_hit }</strong></td>
									</tr>
								</c:when>
								<c:when test="${vo.notice_step==1 }">
									<tr class="text-center">
										<td>${vo.notice_num }</td>
										<c:choose>
											<c:when test="${vo.notice_cate==0 }">
												<td>공지사항</td>
											</c:when>
											<c:when test="${vo.notice_cate==1 }">
												<td>이벤트</td>
											</c:when>
										</c:choose>
										<td><a href = "${pageContext.request.contextPath }/board/noticeDetail.do?menu_num=${menu_num }&notice_num=${vo.notice_num}">${vo.notice_title }</a></td>
										<td>${vo.notice_hit }</td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
				 	</tbody>
				</table>
				<div>
					<input type="button" class="btn btn-primary" value="글쓰기" onclick="location.href='${pageContext.request.contextPath }/board/noticeInsert.do' ">
					<input type="button" class="btn btn-primary" value="목록" onclick="location.href='${cp }/board/noticeList.do?menu_num=${menu_num}&notice_num=${nvo.notice_num }'">
				</div>
				<!-- 검색창 -->
				<div class="row text-center" style="width: 100%">
                    <div style="width: 50%; float:none; margin:0 auto" >
                    	<div id="noticeFind">
							<form method="post" action="${cp }/board/noticeList.do">
								<select name="field" class="form-control col-sm-3" style = "display: inline-block;">
									<option value="notice_all">제목+내용</option>
								  	<option value="notice_title"
										<c:if test="${field=='notice_title' }">
											selected='selected'
										</c:if>
										>제목</option>
									<option value="notice_content"
										<c:if test="${field=='notice_content' }">
											selected='selected'
										</c:if>
										>내용</option>
								</select>
								<input type="text" name="keyword" class="form-control col-sm-5" style = "display: inline-block;">
								<input type="submit" value="검색" class="btn btn-primary">
							</form>	
						</div>
                    </div>
                </div>
				<!-- // 검색창 -->
				
				<!-- 페이징처리 -->
				<c:choose>
            	<c:when test="${startPage!=null}">
		            <div class="row text-center" style="width: 100%;margin-top:50px;" data-aos="fade-up">
		              <div class="col-md-12 text-center">
		                <div class="site-block-27">
		                  <ul>
		                  <c:choose>
							<c:when test="${startPage > 10 }">
								<li><a href = "${cp }/board/noticeList.do?pageNum=$${startPage - 1}&menu_num=${menu_num }">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a>&lt;</a></li>
							</c:otherwise>
							</c:choose>
								<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<li><a href = "${cp }//board/noticeList.do?pageNum=${i}">${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a href = "${cp }/board/noticeList.do?pageNum=${i}">${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < pageCnt }">
									<li><a href = "${cp }/board/noticeList.do?pageNum=${endPage+1 }">&gt;</a></li>
								</c:when>
								<c:otherwise>
									<li><a>&gt;</a></li>
								</c:otherwise>
							</c:choose>
		                  </ul>
		                </div>
		              </div>
		            </div>
	            </c:when>
            </c:choose>
   		<!-- // 페이징처리 -->
   				
			</div>
		</div>
	 </div>

	<script type="text/javascript">
		function getCate(value){
			location.href="${pageContext.request.contextPath }/board/noticeList.do?cate=" + value;
		}
	</script>
</body>
</html>
