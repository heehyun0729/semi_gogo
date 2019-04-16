<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bg-light py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-12 mb-0"><a href="${cp }/home">Home</a>
      	<span class="mx-2 mb-0">/</span> <strong class="text-black">자유게시판 알리미</strong>
      </div>
    </div>
  </div>
</div>
<c:choose>
	<c:when test="${resultCode=='success' }">
		<div style="float:none; margin-left:40%" >글 수정을 성공했습니다. 리스트로 이동하시겠습니까?</div>
		<a style="margin-left: 47%;" class="btn btn-primary btn-sm" href="${pageContext.request.contextPath }/freedom/freedomList.do">리스트 이동</a>
	</c:when>
	<c:otherwise>
		<div style="float:none; margin-left:40%" >글 수정을 실패했습니다. 리스트로 이동하시겠습니까?</div><br>
		<a style="margin-left: 47%;" class="btn btn-primary btn-sm" href="${pageContext.request.contextPath }/freedom/freedomList.do">리스트 이동</a>
	</c:otherwise>
</c:choose>