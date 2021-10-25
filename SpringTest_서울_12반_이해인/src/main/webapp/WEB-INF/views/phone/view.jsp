<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file = "/WEB-INF/views/include/header.jsp" %>

 <table width=590 border=0 cellpadding=0 cellspacing=0>
  <tr>
	<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 조회</b></td>
  </tr>
 </table>  
 <br>

<table>
<tr><td>모델번호</td><td>${phone.num}<td></tr>
<tr><td>모델명</td><td>${phone.model}<td></tr>
<tr><td>가격</td><td>${phone.price}<td></tr>
<tr><td>제조사</td><td>${phone.vendor}<td></tr>
</table>


<a href="${root}/">메인페이제로</a>

</body>
</html>
