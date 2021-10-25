<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>
<h3>조회</h3>
<table>
<tr><td>코드</td><td>${movie.code}<td></tr>
<tr><td>제목</td><td>${movie.title}<td></tr>
<tr><td>가격</td><td>${movie.price}<td></tr>
<tr><td>타입</td><td>${movie.name}<td></tr>
</table>

<p>


<a href="${root}/">홈</a>
<a href="${root}/regist">등록</a>
<a href="${root}/list">목록</a>
<a href="${root}/dele?code=${movie.code}">삭제</a>

</body>
</html>
