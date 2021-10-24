<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<c:set var = "root" value = "${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title>SSAFY 무비</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div align = "right">
<c:if test = "${empty userinfo}">
<a href = "${root}/">로그인</a>
</c:if>
<c:if test = "${!empty userinfo}">
<strong>${userinfo.name}</strong> (${userinfo.id})님 안녕하세요.<br />
</c:if>

</div>
<h2 aling="center">SSAFY 무비</h2>
<hr>
<script>
let msg = "${msg}";
if(msg) alert(msg);
</script>