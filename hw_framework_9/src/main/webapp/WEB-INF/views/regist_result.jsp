<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/views/include/header.jsp" %>

<style>
td:nth-child(3) {
	width: 150px;
}
#cover {
	width: 150px;
}
</style>
<div class="container">
	<h1>상품 등록 결과</h1>
	<c:if test="${not empty product}">
		<table class="table">
			<thead>
				<tr><th>항목</th><th colspan="2">내용</th></tr>
			</thead>
			<tbody>
				<tr><td>상품코드</td><td>${product.item_code}</td><td rowspan="5"><img id="cover" src = "${root}/upload/${product.img}"></td></tr>
				<tr><td>상품명</td><td>${product.item_name}</td></tr>
				<tr><td>판매가</td><td>${product.item_price}</td></tr>
				<tr><td>공급사</td><td>${product.item_corp}</td></tr>
				<%-- <tr><td>이미지</td><td>${product.img}</td></tr> --%>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty product}">
		<p>등록된 상품이 없습니다.</p>
	</c:if>
	<a href="${root}/regist">[추가등록]</a>
	<a href="${root}/list">[목록보기]</a>
</div>

</body>
</html>
			