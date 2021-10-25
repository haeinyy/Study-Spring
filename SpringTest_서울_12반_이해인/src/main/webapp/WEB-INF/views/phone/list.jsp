<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>

 <table width=590 border=0 cellpadding=0 cellspacing=0>
  <tr>
	<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 리스트</b></td>
  </tr>
 </table>  
 <br>

<form action = "${root}/delem" method = "post">
<table>
<tr><th>모델번호</th><th>모델이름</th><th>가격</th><th>제조사명</th><th>삭제</th></tr>
<c:if test="${not empty phones}">
	<c:forEach var="phone" items = "${phones}">
		<tr>
			<td><a class = "desc" href = "${root}/view?num=${phone.num}">${phone.num}</a></td>
			<td>${phone.num}</td>
			<td>${phone.model}</td>
			<td>${phone.price}</td>
			<td>${phone.vendor}</td>
			<td>
				<input type = "checkbox" name = "nums" value= "${phone.num}">
			</td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${empty phones}">
<tr><td colspan = "5">검색된 데이터가 없습니다.</td></tr>
</c:if>
</table>
<p>
<a href="${root}/">홈</a>
<a href="${root}/regist">추가 등록</a>
<input type = "submit" value = "삭제">
</form>
</body>
</html>
