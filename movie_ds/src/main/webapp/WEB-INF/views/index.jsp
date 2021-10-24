<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>
<script>
$(function(){
	$("form").submit(function(){
		if($("#id").val().length==0){
			alert("아이디 확인!!");
			$("#id").focus();
			return false;
		}
		if($("#pass").val().length==0){
			alert("패스워드 확인!!");
			$("#pass").focus();
			return false;
		}
	})
});
</script>
<c:if test = "${empty userinfo}">
<form action ="${root}/login" method="post">
<h3>로그인 해주세요</h3>
아이디 : <input type = "text" id = "id"name = "id" value = "ssafy"><br>
패스워드 : <input type = "password" id = "pass" name = "pass" value = "ssafy"><br>
<input type = "submit" value = "로그인"><br>

</form>
</c:if>
<c:if test = "${!empty userinfo}">
<h3>이미 로그인 되어있습니다</h3>
</c:if>
<p>
<a href="${root}/">홈</a>
<a href="${root}/regist">등록</a>
<a href="${root}/list">목록</a>
</body>
</html>
