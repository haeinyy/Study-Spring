package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.guestbook.model.MemberDto;

@SuppressWarnings("deprecation")
public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	// login 한사람인지 아닌 사람인지 먼저 확인하고 들어가기
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto == null) {
			// 로그인 안한 경우, 로그인 페이지로 보내기
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		return true;
	}
	
}
