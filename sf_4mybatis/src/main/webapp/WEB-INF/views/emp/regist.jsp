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
	직원 등록
</h1>

<form action="${root}/emp/regist" method="post">
코드 : <input type="text" name="num" value="106"><br>
이름 : <input type="text" name="name" value="홍길동"><br>
연봉 : <input type="text" name="salary" value="6000"><br>
<input type="submit" value="등록"><input type="reset">
</form>

<p>
<a href="${root}/">홈으로</a>
<a href="${root}/emp/list">직원목록</a>

</body>
</html>
