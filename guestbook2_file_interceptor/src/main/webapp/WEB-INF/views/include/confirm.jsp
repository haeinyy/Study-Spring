<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:if test="${!empty userinfo}">
	<div class="m-3 text-right">
		<strong>${userinfo.userName}</strong> (${userinfo.userId})님 안녕하세요.
	</div>
	</c:if>