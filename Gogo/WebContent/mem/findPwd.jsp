<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board" class="login-wrapper">
	<div class="box" style="width:40%;height:50%;text-align:center;margin:auto;padding-top:5%;padding-bottom:5%;" >
		<div class="content_wrap">
			<div class="box">
				<h4>FIND MY PASSWORD</h4>
					<form method="post" action="${cp }/mem/findPwd.do">
						<div class="gogo_findPwd">
						</div>
						<input class="form-control" type="text" name="mem_id" placeholder="ID" style="width:30%;margin:auto;">
						<input class="form-control" type="text" name="mem_email" placeholder="EMAIL" style="width:30%;margin:auto;">
						<div style="color:red;font-size:12px;">${msg }</div>
						<br>
						<input type="submit" value="Search" class="btn btn-primary">
				</form> 
			</div>
		</div>
	</div>
</div>