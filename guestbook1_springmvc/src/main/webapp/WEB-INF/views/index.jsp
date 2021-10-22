<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/views/include/header.jsp" %>

    <div align="center">
      <h3>SSAFY 방명록!!!(Spring Framework)</h3>
      <c:if test="${empty userinfo}">
	      <a href="${root}/user/register">회원가입</a><br />
	      <a href="${root}/user/login">로그인</a><br />
      </c:if>
      <c:if test="${!empty userinfo}">
	      <strong>${userinfo.userName}</strong> (${userinfo.userId})님 안녕하세요.<br />
	      <a href="${root}/user/logout">로그아웃</a><br />
	      <a href="${root}/guestbook/list?pg=1&key=&word=">글목록</a><br /> <!-- pg:페이지번호/검색조건/검색어  -->
      </c:if>																<!-- 반드시 명시!! (지금안써서 비워둔것! 근데 안써도 명시해주기!) -->
    </div>
  </body>
</html>
