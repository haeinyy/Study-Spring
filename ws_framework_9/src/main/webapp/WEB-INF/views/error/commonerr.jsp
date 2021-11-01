<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="container">
	<c:if test="${not empty errmsg}">
		<h1>${errmsg}</h1>
	</c:if>
	<c:if test="${empty errmsg}">
		<h1>서버 오류입니다. 다시 시도해주세요.</h1>
	</c:if>
</div>
</body>
</html>