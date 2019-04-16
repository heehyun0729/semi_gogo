<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${resultCode=='success' }">
		수정 성공하였습니다.
		<a href="${pageContext.request.contextPath }/freedom/freedomList.do">리스트 이동</a>
	</c:when>
	<c:otherwise>
		수정 실패하였습니다.
		<a href="${pageContext.request.contextPath }/freedom/freedomList.do">리스트이동 이동</a>
	</c:otherwise>
</c:choose>
