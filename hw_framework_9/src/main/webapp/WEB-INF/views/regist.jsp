<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/views/include/header.jsp" %>

<style>
label {
	display: inline-block;
	width: 80px;
}
textarea {
	width: 100%;
}
</style>
<div class="container">
	<h1>도서 등록</h1>
	<form method="post" action="${root}/regist">
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<div class="form-group">
			<label for="isbn">상품코드</label>
			<input type="text" id="item_code" name="item_code" class="form-control-sm" value="111-222-3333">
		</div>
		<div class="form-group">
			<label for="title">상품명</label>
			<input type="text" id="item_name" name="item_name" class="form-control-sm" value="상품1">
		</div>
		<div class="form-group">
			<label for="author">판매가</label>
			<input type="number" id="item_price" name="item_price" class="form-control-sm" value="10000">
		</div>
		<div class="form-group">
			<label for="price">공급사</label>
			<input type="text" id="item_corp" name="item_corp" class="form-control-sm" value="2">
		</div>
		<div class="form-group">
			<label for="img">이미지</label>
			<input type="file" id="img" name="file" class="form-control-file-sm" accept="image/*">
		</div>
		<div class="form-group">
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</div>
	</form>
	<br>
	<a href="${root}/list">도서 목록</a>
</div>
</body>
</html>
			