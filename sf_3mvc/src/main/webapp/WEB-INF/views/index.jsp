<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
${root}
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
<P>  The time on the server is ${serverTime}. </P>
<a href="${root}/hello?num=123">호출123</a>
<a href="${root}/hello?num=456">호출456</a>
<a href="${root}/hello?num=abc">호출abc</a>
</body>
</html>
