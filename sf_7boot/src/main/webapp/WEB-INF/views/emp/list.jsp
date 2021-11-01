<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
	<meta charset="utf-8">
	<title>직원목록</title>
</head>
<body>
<h1>
	직원 목록
</h1>
<table border="1" style="border-collapse: collapse;">
	<tr><th>코드</th><th>이름</th><th>연봉</th></tr>
	
<c:if test="${not empty emps}">
<c:forEach var="emp" items="${emps}">
	<tr>
		<td>${emp.num}</td>
		<td><a href="${root}/emp/view?num=${emp.num}">${emp.name}</a></td>
		<td>${emp.salary}</td>
	</tr>
</c:forEach>
</c:if>
	
<c:if test="${empty emps}">
	<tr><td colspan="3">조회된 정보가 없습니다.</td></tr>
</c:if>

</table>

<p>
<a href="${root}/">홈으로</a>
<a href="${root}/emp/regist">직원등록</a>

</body>
</html>
