<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>

<h3>등록</h3>
<form action ="${root}/regist" method="post">
코드 : <input type = "text" id = "code"name = "code" value = "104"><br>
제목 : <input type = "text" id = "title" name = "title" value = "국가대표"><br>
가격 : <input type = "text" id = "price" name = "price" value = "5000"><br>
타입 : <select id = "no" name = "no">
<option value = "co">코미디</option>
<option value = "sf">판타지</option>
<option value = "dr" selected>드라마</option>
</select><br>

<input type = "submit" value = "등록"><input type = "reset" value = "초기화"><br>
</form>
<p>
<a href="${root}/">홈</a>
<a href="${root}/regist">등록</a>
<a href="${root}/list">목록</a>

</body>
</html>
