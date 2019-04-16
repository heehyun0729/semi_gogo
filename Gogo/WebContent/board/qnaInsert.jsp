<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 카테고리명 -->
<div class="bg-light py-3">
     <div class="container">
       <div class="row">
         <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">community</strong>
         	<span class="mx-2 mb-0">/</span> <strong class="text-black">문의</strong>
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
               <div class="float-md-left mb-4"><h2 class="text-black h5">문의</h2></div>
            </div>
             <div style = "width: 60%; margin-left: 20%; margin-right: 20%; margin-top: 50px;">
            <form method="post" action="${cp }/board/qnaInsert" enctype="multipart/form-data">
              	<input type = "hidden" name = "menu_num" value = "${menu_num }">
				<input type = "hidden" name = "qna_num" value = "${vo.qna_num }">
				<input type = "hidden" name = "qna_ref" value = "${vo.qna_ref }">
				<input type = "hidden" name = "qna_level" value = "${vo.qna_level }">
				<input type = "hidden" name = "qna_step" value = "${vo.qna_step }">
              <div class="p-5 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="cate" class="text-black">카테고리 </label>
                    <select name = "cate" id = "cate" class="form-control">
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
                  <div class="col-md-6">
                    <label for="pwd" class="text-black">비밀번호</label>
                    <input type = "password" name = "pwd" id = "pwd" class="form-control">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-sm btn-primary btn-block" value="등록">
                  </div>
                  <div class="col-lg-6">
                    <input type="button" class="btn btn-sm btn-outline-primary btn-block" value="취소" onclick="javascript:history.go(-1)">
                  </div>
                </div>
              </div>
            </form>
          </div>
       </div> <!-- // row -->
   </div> <!-- // container -->
</div> <!-- //site-section -->