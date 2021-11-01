<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
	<meta charset="utf-8">
	<title>직원상세정보</title>
</head>
<body>
<h1>
	직원 상세정보
</h1>
<table border="1" style="border-collapse: collapse;">
	<tr><th>코드</th><td>${emp.num}</td></tr>
	<tr><th>이름</th><td>${emp.name}</td></tr>
	<tr><th>연봉</th><td>${emp.salary}</td></tr>
</table>

<p>
<a href="${root}/">홈으로</a>
<a href="${root}/emp/list">직원목록</a>
<a href="${root}/emp/regist">직원등록</a>
<a href="${root}/emp/dele?num=${emp.num}">직원삭제</a>

</body>
</html>
