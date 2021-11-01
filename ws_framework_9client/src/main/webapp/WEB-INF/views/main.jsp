<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="http://localhost:8080/ws" scope="session"/>
<%-- <c:set var="root" value="${pageContext.request.contextPath}" scope="session"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 REST</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function printResult(msg){
	$("#isbn").val("");
	$("#title").val("");
	$("#author").val("");
	$("#price").val("");
	$("#content").val("");
	
	$("#result").html(msg);
}
function getFormData(){
	let book={};
	book.isbn=$("#isbn").val();
	book.title=$("#title").val();
	book.author=$("#author").val();
	book.price=$("#price").val();
	book.content=$("#content").val();
	return book;
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
			url : "${root}/bookapi/book",
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
			url : "${root}/bookapi/book/" + this.innerText.split(" ")[0],
			type : "get",
			success : function(book) {
				$("#isbn").val(book.isbn);
				$("#title").val(book.title);
				$("#author").val(book.author);
				$("#price").val(book.price);
				$("#content").val(book.content);
				
				$("#result").html("조회 성공");
			},
			error : function(xhr,status,msg) {
				alert("요청 실패");
			}
		});
	});
	$("#badd").click(function(){
 		$.ajax({
			url : "${root}/bookapi/book",
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
			url : "${root}/bookapi/book",
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
			url : "${root}/bookapi/book/" + $("#isbn").val(),
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
<h1>SSAFY 도서 REST</h1>

<button id="blst">목록조회</button> (상세 내용을 조회하기 위해서 목록의 아이템을 클릭하세요.)
<ul id="list"></ul>
<button id="badd">추가</button>
<button id="bupd">수정</button>
<button id="bdel">삭제</button>
<button id="bcle">초기화</button><br>
<br>

<form>
도서번호 : <input type="text" id="isbn" name="isbn" value="11"><br>
도서제목 : <input type="text" id="title" name="title" value="스프링"><br>
도서저자 : <input type="text" id="author" name="author" value="오싸피"><br>
도서가격 : <input type="text" id="price" name="price" value="5050"><br>
도서내용 : <textarea id="content" name="content">정말 쉬운 코딩</textarea><br>
</form>
<br>

<div id="result"></div>
</body>
</html>