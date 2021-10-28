<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
	<meta charset="utf-8">
	<title>Index</title>
</head>
<body>
<h1>
	Hello world! 안녕^^
</h1>
<p>
<img alt="tomcat" src="${root}/img/tomcat.png">
<p>
<a href="${root}/emp/list">직원목록</a>
<a href="${root}/rest">직원REST</a>
<a href="${root}/swagger-ui/index.html">직원API</a>


</body>
</html>
