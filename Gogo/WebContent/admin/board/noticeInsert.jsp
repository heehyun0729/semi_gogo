<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light py-3">
   <div class="container">
     <div class="row">
       <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">COMMUNITY</strong>
       	<span class="mx-2 mb-0">/</span> <strong class="text-black">공지사항 등록</strong>
       </div>
     </div>
   </div>
</div>
<div class="site-section">
	<div class="container">
		<div class="row" >
		<!-- 해당 사이트 제목 -->
			<div class="col-md-12 mb-6">
               <div class="float-md-left mb-4"><h2 class="text-black h5">공지등록</h2></div>
            </div>
		<!--// 해당 사이트 제목 -->
			<div style="width: 70%;margin-left: 15%;margin-right: 15%;">
				<form method="post" action="${cp}/board/noticeInsert.do?menu_num=${menu_num}" enctype="multipart/form-data">
					<table class="table table-hober">
						<tr>
							<td style="text-align: center;">카테고리</td>
							<td>
								<select name = "cate">
									<option value = "0">공지사항</option>
									<option value = "1">이벤트</option>
								</select>
								&nbsp;&nbsp;&nbsp;중요한 공지<input type="checkbox" name="step" value="0">
							</td>
						</tr>
						<tr>
							<td style="text-align: center;">제목</td>
							<td><input type = "text" style="width: 500px;" name = "title"></td>
						</tr>
						<tr>
							<td colspan = "2" style="text-align: center;"><textarea rows = "10" cols = "80" name = "content"></textarea></td>
						</tr>
						<tr>
							<td style="text-align: center;">첨부파일1</td>
							<td><input type ="file" name = "file1"></td>
						</tr>
						<tr>
							<td style="text-align: center;">첨부파일2</td>
							<td><input type = "file" name = "file2"></td>
						</tr>
						<tr>
							<td style="text-align: center;">첨부파일3</td>
							<td><input type = "file" name = "file3"></td>
						</tr>
						<tr>
							<td colspan = "2">
								<input type = "submit" class="btn btn-primary" value = "등록" style="margin-left: 45%;">
								<input type = "button" class="btn btn-primary" value = "취소" onclick="javascript:history.go(-1)">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div> <!-- // row -->
   </div> <!-- // container -->
</div> <!-- //site-section -->