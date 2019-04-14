<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::::::::: GOGO 고장난 고양이 ::::::::::</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel = "stylesheet" type = "text/css" href = "${cp }/css/common.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript" src = "${cp }/js/join.js"></script>
<script type="text/javascript" src = "${cp }/js/qna.js"></script>
<script type="text/javascript" src = "${cp }/js/checkbox.js"></script>
<script type="text/javascript" src = "${cp }/js/basket.js"></script>
<script type="text/javascript" src = "${cp }/js/product.js"></script>
<script type="text/javascript" src = "${cp }/js/buy.js"></script>
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