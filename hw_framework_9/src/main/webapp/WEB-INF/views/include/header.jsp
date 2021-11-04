<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta>
	<title>SSAFY 상품 관리</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${root}/css/common.css">
</head>
<body>
<div class="container">
	<img src="${root}/img/ssafy_logo.png" id="ssafy_logo">
	<h1 class="display-4 text-center">상품 관리</h1>
	<br>
	<div class="text-right">
		<c:if test="${empty userinfo}">
			<form method="post" action="${root}/login">
				<div class="form-group">
					<input type="text" name="id" placeholder="아이디" value="ssafy">
					<input type="password" name="pass" placeholder="비밀번호" value="1234">
					<input type="submit" class="btn btn-primary" value="로그인">
				</div>
			</form>
		</c:if>
		<c:if test="${!empty userinfo}">
			<div>
				${userinfo.name}님 반갑습니다.
				<a href="${root}/logout">로그아웃</a>
			</div>
		</c:if>
	</div>
</div>
<hr>
<script>
let msg = "${msg}";
if (msg) {
	alert(msg)
}
</script>
