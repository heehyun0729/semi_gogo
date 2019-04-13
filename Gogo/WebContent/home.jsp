<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::::::::: GOGO 고장난 고양이 ::::::::::</title>
<link rel = "stylesheet" type = "text/css" href = "${cp }/css/common.css">
<script type="text/javascript" src = "${cp }/js/join.js"></script>
<script type="text/javascript" src = "${cp }/js/qna.js"></script>
<script type="text/javascript" src = "${cp }/js/checkbox.js"></script>
<script type="text/javascript" src = "${cp }/js/basket.js"></script>
<script type="text/javascript" src = "${cp }/js/product.js"></script>
</head>
<body>
<div id = "wrap">
	<div id = "header">
		<jsp:include page="header.jsp"/>
	</div>
	<div id = "content">
		<jsp:include page="${spage }"/>
	</div>
	<div id = "footer">
		<jsp:include page="footer.jsp"/>
	</div>
</div>
</body>
</html>