<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">community</strong>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">공지사항삭제</strong>
       </div>
     </div>
   </div>
</div>
<div class="site-section" style = "padding-bottom: 20px;">
	<div class="container">
		<!-- 해당 사이트 제목 -->
		<div class="col-md-12 mb-5">
		   <div class="float-md-left mb-4"><h2 class="text-black h5">공지사항삭제</h2></div>
		</div>
		<!-- // 해당 사이트 제목 -->
  </div> <!-- // container -->
</div> <!-- //site-section -->
	<form method="post" action="${cp }/board/noticeDelete.do">
		<input type = "hidden" name = "menu_num" value = "${menu_num }">
		<input type = "hidden" name = "notice_num" value = "${notice_num }">
		<p style="margin-left: 44%;">글을 정말로 삭제할까요?</p>
		<div style="margin-left: 45%;margin-bottom: 100px;margin-top: 10px;">
			<input class="btn btn-sm btn-primary" type = "submit" value = "삭제">
			<input class="btn btn-sm btn-outline-primary" type = "button" value = "취소" onclick="javascript:history.go(-1);">
		</div>
	</form>