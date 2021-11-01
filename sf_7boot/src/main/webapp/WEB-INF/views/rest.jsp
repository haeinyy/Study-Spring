<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
	<meta charset="utf-8">
	<title>직원 REST</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		function printResult(msg) {
			$("#num").val("");
			$("#name").val("");
			$("#salary").val("");
			$("#result").html(msg);
		}
		
		function updateList(emps) {
			$('#list').empty();
			$.each(emps, function(idx, emp) {
				$("#list").append("<li>"+emp.num+" "+emp.name+" "+emp.salary+"</li>");
			});
		}
		
		function getFormData() {
			let emp={};
			emp.num=$("#num").val();
			emp.name=$("#name").val();
			emp.salary=$("#salary").val();
			return emp;
		}
		
		$(function () {
			$("#btnList").click(function() {
				$.ajax({
					url : "${root}/empapi/emp",
					type : "get",
					success : function(data) {
						updateList(data);
						// printResult("검색성공");
					},
					error :function(xhr, status, msg){
						alert("요청 실패");
					}
				});
			});
			$("#list").on("click","li",function() {
				$.ajax({
					url : "${root}/empapi/emp/"+this.innerText.split(" ")[0],
					type : "get",
					success : function(emp) {
						$("#num").val(emp.num);
						$("#name").val(emp.name);
						$("#salary").val(emp.salary);
						$("#result").html("조회 성공");
					},
					error :function(xhr, status, msg){
						alert("요청 실패");
					}
				});
			});
			$("#btnAdd").click(function() {
				$.ajax({
					url : "${root}/empapi/emp",
					type : "post",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify(getFormData()),
					success : function(data) {
						// updateList(data);
						$("#btnList").trigger("click");
						printResult("추가 성공");
					},
					error :function(xhr, status, msg){
						alert("요청 실패");
					}
				});
			});
			$("#btnUpda").click(function() {
				$.ajax({
					url : "${root}/empapi/emp",
					type : "put",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify({num:$("#num").val(),salary:$("#salary").val()}),
					success : function(data) {
						$("#btnList").trigger("click");
						printResult("수정 성공");
					},
					error :function(xhr, status, msg){
						alert("요청 실패");
					}
				});
			});
			$("#btnDel").click(function() {
				$.ajax({
					url : "${root}/empapi/emp/"+$("#num").val(),
					type : "delete",
					success : function(data) {
						$("#btnList").trigger("click");
						printResult("삭제 성공");
					},
					error :function(xhr, status, msg){
						alert("요청 실패");
					}
				});
			});
			
			$("#btnReset").click(function(){
				printResult("");
			});
			
			$("#btnList").trigger("click");
		});
	</script>
</head>
<body>
<h1>
	직원 REST
</h1>

<button id="btnList">목록조회</button>
<ul id="list"></ul>
<button id="btnAdd">추가</button>
<button id="btnUpda">수정</button>
<button id="btnDel">삭제</button>
<button id="btnReset">초기화</button>
<br><br>

<form >
코드 : <input type="text" id="num" value="106"><br>
이름 : <input type="text" id="name" value="홍길동"><br>
연봉 : <input type="text" id="salary" value="6000"><br>
</form>
<br>

<div id="result"></div>

<p>
<a href="${root}/">홈으로</a>
<a href="${root}/emp/list">직원목록</a>


</body>
</html>
