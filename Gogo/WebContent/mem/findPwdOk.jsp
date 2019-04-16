<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="board">
	<div class="box" style="width:40%;height:50%;text-align:center;margin:auto;padding-top:5%;padding-bottom:5%;" >
		<h5>Your Password is</h5>
			<input class="form-control" type="text" name="mem_pwd" value="${result}" style="width:15%;margin:auto;text-align:center;color:black;font-weight:bold;">
			<a href="${cp }/mem/login">Go to Login</a>
	</div>
</div>