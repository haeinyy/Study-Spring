<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/views/include/header.jsp" %>

<div class="container">
	<h1>상품 목록</h1>
	<%@ include file="/WEB-INF/views/include/search.jsp" %>
	<table class="table table-striped">
		<thead>
			<tr><th>번호</th><th>상품코드</th><th>상품명</th><th>판매가</th><th>공급사</th></tr>
		</thead>
		<tbody>
		<c:forEach var="product" items="${products}" varStatus="vs">
			<tr><td>${vs.count}</td><td>${product.item_code}</td><td>${product.item_name}</td><td>${product.item_price}</td><td>${product.item_corp}</td></tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<%@ include file="/WEB-INF/views/include/paging.jsp" %>
	<a href="${root}/regist">상품 등록</a>
</div>

</body>
</html>
			