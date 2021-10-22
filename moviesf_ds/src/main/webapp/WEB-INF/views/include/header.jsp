<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<div align="right">
<c:if test="${empty userinfo }">
<a href="${root}">로그인</a>
</c:if>
<c:if test="${not empty userinfo }">
${userinfo.name}님 로그인 되었습니다. <a href="${root}/logout">로그아웃</a>
</c:if>
</div>

<h2 align="center">SSAFY Movie</h2>

<script type="text/javascript">
let msg = "${msg}";
if(msg) alert(msg);
</script>