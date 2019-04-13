<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<div>
		<h1>글등록하기</h1>
	</div>
	<div>
		<form method="post" action="${cp}/board/noticeInsert.do" enctype="multipart/form-data">
			<table border = "1" style="width: 500px;">
				<tr>
					<td>카테고리</td>
					<td>
						<select name = "cate">
							<option value = "0">공지사항</option>
							<option value = "1">이벤트</option>
						</select>
						&nbsp;&nbsp;&nbsp;중요한 공지<input type="checkbox" name="step" value="0">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type = "text" name = "title"></td>
				</tr>
				<tr>
					<td colspan = "2"><textarea rows = "10" cols = "80" name = "content"></textarea></td>
				</tr>
				<tr>
					<td>첨부파일1</td>
					<td><input type = "file" name = "file1"></td>
				</tr>
				<tr>
					<td>첨부파일2</td>
					<td><input type = "file" name = "file2"></td>
				</tr>
				<tr>
					<td>첨부파일3</td>
					<td><input type = "file" name = "file3"></td>
				</tr>
				<tr>
					<td colspan = "2">
						<input type = "submit" value = "등록">
						<input type = "button" value = "취소" onclick="javascript:history.go(-1)">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>