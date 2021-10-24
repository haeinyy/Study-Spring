<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>
<script>

$(function(){
	$(".desc").mouseover(function(){
		let codeNum = $(this).text();
		$.ajax({
			url : "${root}/desc",
			type : "get",
			data : {code: codeNum},
			success: function(data){
				$("#result").html("<h5>"+data+"</h5>").css("color","red");
			},
			error : function(xhr, status, msg){
				alert("error : "+msg);
			}
		});
	})
	$(".desc").mouseout(function(){
		$("#result").empty()	
	})
})

</script>
<h3>목록</h3>
<form action = "${root}/list" method = "get">
<select name = "key">
<option value = "LIST">전체</option>
<option value = "TITLE"<c:if test = "${key eq 'TITLE'}">selected</c:if>>제목</option>
<option value = "PRICE"<c:if test = "${key eq 'PRICE'}">selected</c:if>>가격</option>
</select>
<input type = "text" name = "word" value = "${word}">
<input type = "submit" value = "검색">
</form>

<form action = "${root}/delem" method = "post">
<table>
<tr><th>코드</th><th>제목</th><th>가격</th><th>타입</th><th><input type = "submit" value = "삭제"></th></tr>
<c:if test="${not empty movies}">
	<c:forEach var="movie" items = "${movies}">
		<tr>
			<td><a class = "desc" href = "${root}/view?code=${movie.code}">${movie.code}</a></td>
			<td>${movie.title}</td>
			<td>${movie.price}</td>
			<td>${movie.name}</td>
			<td>
				<input type = "checkbox" name = "codes" value= "${movie.code}">
			</td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${empty movies}">
<tr><td colspan = "5">검색된 데이터가 없습니다.</td></tr>
</c:if>
</table>
</form>

<div id="result">

</div>
<p>
<a href="${root}/">홈</a>
<a href="${root}/regist">등록</a>
</body>
</html>
