<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 카테고리명 -->
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
<!-- // 카테고리명 -->
<div class="site-section">
	<div class="container">
		<div class="row" >
			<!-- 해당 사이트 제목 -->
			<div class="col-md-12 mb-6">
               <div class="float-md-left mb-4"><h2 class="text-black h5">후기</h2></div>
            </div>
             <div style = "width: 60%; margin-left: 20%; margin-right: 20%; margin-top: 50px;">
            <form method="post" action="${cp }/board/reviewInsert" enctype="multipart/form-data">
              <div class="p-5 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="prod" class="text-black">구매한 상품 </label>
                    <c:choose>
						<c:when test="${!empty detailBuy_num }">
							<input type = "hidden" name = "prod" value = "${detailBuy_num }">
							${prod_name } [옵션: ${op_name } - ${detailOp_name }(+${detailOp_price })]
						</c:when>
						<c:otherwise>
							<select id = "prod" name = "prod" class="form-control">
								<option value = "">- [필수]선택 -</option>
								<c:forEach var = "vo" items = "${list }">
									<option value = "${vo.detailBuy_num }">${vo.prod_name }
										<c:if test="${vo.prod_name != vo.op_name }">
											[옵션: ${vo.op_name } - ${vo.detailOp_name }(+${vo.detailOp_price })]
										</c:if>
									</option>
								</c:forEach>
							</select>
						</c:otherwise>
					</c:choose>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="title" class="text-black">제목</label>
                    <input type = "text" name = "title" id = "title" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="content" class="text-black">내용 </label>
                    <textarea name="content" id="content" cols="30" rows="7" class="form-control"></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12 text-center">
					<fieldset class="rating">
					    <input type="radio" id="star5" name="star" value="5" /><label class = "full" for="star5"></label>
					    <input type="radio" id="star4" name="star" value="4" /><label class = "full" for="star4"></label>
					    <input type="radio" id="star3" name="star" value="3" /><label class = "full" for="star3"></label>
					    <input type="radio" id="star2" name="star" value="2" /><label class = "full" for="star2"></label>
					    <input type="radio" id="star1" name="star" value="1" /><label class = "full" for="star1"></label>
					</fieldset>                  
					</div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="file1" class="text-black">첨부파일1</label>
                    <input type = "file" name = "file1" id = "file1" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="file2" class="text-black">첨부파일2</label>
                    <input type = "file" name = "file2" id = "file2" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="file3" class="text-black">첨부파일3</label>
                    <input type = "file" name = "file3" id = "file3" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-block" value="등록">
                  </div>
                  <div class="col-lg-6">
                    <input type="button" class="btn btn-primary btn-block" value="취소" onclick="javascript:history.go(-1)">
                  </div>
                </div>
              </div>
            </form>
          </div>
       </div> <!-- // row -->
   </div> <!-- // container -->
</div> <!-- //site-section -->