<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 상품 REST</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function printResult(msg){
	$("#item_code").val("");
	$("#item_name").val("");
	$("#item_price").val("");
	$("#item_corp").val("");
	
	$("#result").html(msg);
}
function getFormData(){
	let product={};
	product.item_code=$("#item_code").val();
	product.item_name=$("#item_name").val();
	product.item_price=$("#item_price").val();
	product.item_corp=$("#item_corp").val();
	return product;
}
function updateList(books){
	$("#list").empty();
	$.each(books, function(idx, book){
		$("#list").append("<li>"+book.isbn+" "+book.title+" "+book.author+" "+book.price+"</li>");
	});
}
$(function(){
	$("#blst").click(function(){
		$.ajax({
			url : "${root}/productapi/product",
			type : "get",
			success : function(data) {
				updateList(data);
				//printResult("검색 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});
	$("#list").on("click", "li", function() {
		$.ajax({
			url : "${root}/productapi/product/" + this.innerText.split(" ")[0],
			type : "get",
			success : function(book) {
				
				$("#item_code").val(product.item_code);
				$("#item_name").val(product.item_name);
				$("#item_price").val(product.item_price);
				$("#item_corp").val(product.item_corp);
				
				$("#result").html("조회 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});
	$("#badd").click(function(){
 		$.ajax({
			url : "${root}/productapi/product",
			type : "post",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(getFormData()),
			success : function(data) {
				$("#blst").trigger("click");
				printResult("추가 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});	
	$("#bupd").click(function() {
		$.ajax({
			url : "${root}/productapi/product",
			type : "put",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(getFormData()),
			success : function(data) {
				$("#blst").trigger("click");
				printResult("수정 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});	
	$("#bdel").click(function() {
		$.ajax({
			url : "${root}/productapi/product/" + $("#item_code").val(),
			type : "delete",
			success : function(data) {
				$("#blst").trigger("click");
				printResult("삭제 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});
	$("#bcle").click(function(){
		printResult("");
	});
	
	$("#blst").trigger("click");
});
</script>
</head>
<body>
<c:if test="${not empty userinfo}">
<h4 align="right">[${userinfo.name}] <a href="${root}/logout">로그아웃</a></h4>
</c:if>
<h1>SSAFY 상품 REST</h1>

<button id="blst">목록조회</button> (상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
<ul id="list"></ul>
<button id="badd">추가</button>
<button id="bupd">수정</button>
<button id="bdel">삭제</button>
<button id="bcle">초기화</button><br>
<br>

<form>
상품코드 : <input type="text" id="item_code" name="item_code" value="2"><br>
상품명 : <input type="text" id="item_name" name="item_name" value="닌텐도스위치"><br>
판매가 : <input type="text" id="item_price" name="item_price" value="300000"><br>
공급사 : <input type="text" id="item_corp" name="item_corp" value="삼성"><br>
</form>
<br>

<div id="result"></div>
</body>
</html>