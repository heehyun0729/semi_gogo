<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 카테고리명 -->
		<div class="bg-light py-3">
		     <div class="container">
		       <div class="row">
		         <div class="col-md-12 mb-0"><a href="${cp }/admin/home">Home</a>
		         	<span class="mx-2 mb-0">/</span> <strong class="text-black">COMMUNITY</strong>
		         	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의</strong>
		         </div>
		       </div>
		     </div>
	    </div>
		<!-- // 카테고리명 -->
		<div class="site-section">
			<div class="container">
				<div class="row">
				
					<!-- 해당 사이트 제목 -->
					<div class="col-md-12 mb-5">
		               <div class="float-md-left mb-4">
			               <h2 class="text-black h5">문의</h2>
			               <p style="margin-left: 0px;">관리자페이지<p>
		               </div>
		            </div>
		            <!-- // 해당 사이트 제목 -->
		            <form class = "col-md-12" method="post" action="${cp }/board/qnaDelete?select=ck&menu_num=${param.menu_num}">
		            <input type = "hidden" name = "menu_num" value = "${param.menu_num}">
		            <div style = "width: 100%;">
		            <select name = "cate" onchange="getQnaList(this.value)" class="form-control col-sm-2" style = "float: left; display: inline-block;">
						<option value = "">전체</option>
						<option value = "prod"
							<c:if test = "${cate == 'prod'}">
								selected = "selected"
							</c:if>
						>상품</option>
						<option value = "ship"
							<c:if test = "${cate == 'ship'}">
								selected = "selected"
							</c:if>
						>배송</option>
						<option value = "cancel"
						
							<c:if test = "${cate == 'cancel'}">
								selected = "selected"
							</c:if>
						>교환/반품</option>
						<option value = "pay"
							<c:if test = "${cate == 'pay'}">
								selected = "selected"
							</c:if>
						>결제</option>
						<option value = "etc"
							<c:if test = "${cate == 'etc'}">
								selected = "selected"
							</c:if>
						>기타</option>
					</select>
		            <a class="btn btn-primary" href = "${cp }/board/qnaInsert?menu_num=${param.menu_num}" style = "float: right;">글쓰기</a>
		            <input type = "submit" value = "삭제" class="btn btn-primary" style = "float: right;margin-bottom: 20px;margin-right: 5px;">
		            </div>
		            <!-- 테이블 -->
		            <table class="table table-hover">
					 	<thead>
					 		<tr class="text-center">
					 			<th><input type = "checkbox" id = "ckAll" onclick="checkAll()"></th>
					 			<th>번호</th>
					 			<th>카테고리</th>
					 			<th>제목</th>
					 			<th>작성자</th>
					 			<th>작성일</th>
					 			<th>수정</th>
					 		</tr>
					 	</thead>
					 	<tbody>
						 	<c:forEach var = "vo" items = "${list }">
								<tr class="text-center">
									<td><input type = "checkbox" name = "check" value = "${vo.qna_num }" onclick="isChecked()"></td>
									<td>${vo.qna_num }</td>
									<td>
										<c:choose>
											<c:when test="${vo.qna_cate == 'prod' }">
												상품
											</c:when>
											<c:when test="${vo.qna_cate == 'ship' }">
												배송
											</c:when>
											<c:when test="${vo.qna_cate == 'cancel' }">
												교환/반품
											</c:when>
											<c:when test="${vo.qna_cate == 'pay' }">
												결제
											</c:when>
											<c:when test="${vo.qna_cate == 'etc' }">
												기타
											</c:when>
										</c:choose>
									</td>
									<td>
										<c:if test="${vo.qna_level > 0 }">
											<c:forEach var = "i" begin = "1" end = "${vo.qna_level }">
												&nbsp;&nbsp;
											</c:forEach>
											[re]
										</c:if>
										<a href = "${cp }/board/qnaDetail?menu_num=${param.menu_num}&qna_num=${vo.qna_num}">${vo.qna_title }</a>
									</td>
									<c:choose>
										<c:when test="${vo.mem_id == 'admin' }">
											<td><span style="font-weight: bold;">GOGO</span></td>
										</c:when>
										<c:otherwise>
											<td>${vo.mem_id }</td>
										</c:otherwise>
									</c:choose>
									<td>${vo.qna_wdate }</td>
									<td><a href = "${cp }/board/qnaUpdate?menu_num=${param.menu_num}&qna_num=${vo.qna_num}">수정</a></td>
								</tr>
							</c:forEach>
					 	</tbody>
					 </table>
					 </form>
		            <!-- // 테이블 -->
		            
		            <!-- 검색창 -->
					<div class="row text-center" style="width: 100%">
	                    <div style="width: 50%; float:none; margin:0 auto" >
		                    <div id = "search">
								<form method="post" action="${cp }/board/qna?menu_num=${param.menu_num}">
									<select name = "field" class="form-control col-sm-3" style = "display: inline-block;">
										<option value = "all"
											<c:if test = "${field == 'all' }">
												selected = "selected"
											</c:if>
										>제목+내용</option>
										<option value = "qna_title"
											<c:if test = "${field == 'qna_title' }">
												selected = "selected"
											</c:if>
										>제목</option>
										<option value = "qna_content"
											<c:if test = "${field == 'qna_content' }">
												selected = "selected"
											</c:if>
										>내용</option>
										<option value = "mem_id"
											<c:if test = "${field == 'mem_id' }">
												selected = "selected"
											</c:if>
										>작성자</option>
									</select>
									<input type = "text" name = "keyword" value = "${keyword }" class="form-control col-sm-5" style = "display: inline-block;">
									<input type = "submit" class="btn btn-primary" value = "검색">
								</form>
							</div>
	                    </div>
	                </div>
	                <!-- //검색창 -->
	                
	                <!-- 페이징처리 -->
	                <c:choose>
            	<c:when test="${startPage!=null}">
		            <div class="row text-center" style="width: 100%;margin-top:50px;" data-aos="fade-up">
		              <div class="col-md-12 text-center">
		                <div class="site-block-27">
		                  <ul>
		                  <c:choose>
							<c:when test="${startPage > 10 }">
								<li><a href = "${cp }/board/qna?menu_num=${param.menu_num}&pageNum=${startPage - 1}">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a>&lt;</a></li>
							</c:otherwise>
							</c:choose>
								<c:forEach var = "i" begin = "${startPage }" end = "${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<li><a href = "${cp }/board/qna?menu_num=${param.menu_num}&pageNum=${i}">${i }</a></li>
									</c:when>
									<c:otherwise>
										<li><a href = "${cp }/board/qna?menu_num=${param.menu_num}&pageNum=${i}">${i }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${endPage < pageCnt }">
									<li><a href = "${cp }/board/qna?menu_num=${param.menu_num}&pageNum=${endPage + 1}">&gt;</a></li>
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

         </div> <!-- // row -->
     </div> <!-- // container -->
  </div> <!-- //site-section -->
		  
  	<script type="text/javascript">
		function getQnaList(value) {
			location.href = "${cp}/board/qna?menu_num=10&cate=" + value + "&field=${field}&keyword=${keyword}";
		}
	</script>