<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<script>
$(function(){
	$("form").submit(function(){
		if($("#id").val().length==0){
			alert("아이디 확인!!");
			$("#id").focus();
			return false;
		}
		if($("#pw").val().length==0){
			alert("패스워드 확인!!");
			$("#pw").focus();
			return false;
		}
	})
});
</script>
<div align="center">
<h4 align="center">메인페이지</h4>
<c:if test = "${empty userinfo}">
<form action ="${root}/login" method="post">
<h3>로그인 해주세요</h3>
아이디 : <input type = "text" id = "id" name = "id" value = "ssafy"><br>
패스워드 : <input type = "password" id = "pw" name = "pw" value = "ssafy"><br>
<input type = "submit" value = "로그인"><br>
</form>
</c:if>
<c:if test = "${!empty userinfo}">
<!-- <h3>로그인 되었습니다. 아래 항목 중 선택해주세요</h3> -->
</c:if>

<%-- <a href="${root}/">홈으로</a> --%>
<br><br>
<a href="${root}/regist">핸드폰등록</a>
<br>
<a href="${root}/list">핸드폰목록</a>
</div>
</body>
</html>