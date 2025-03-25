package com.practice.training.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.practice.training.service.TokenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Skip authentication for the login API
		String requestURI = request.getRequestURI();
		System.out.println(request);
		if (requestURI.contains("/auth/login")) {
			return true;
		}

		// Check for Authorization token in headers
		String token = request.getHeader("Authorization");
		String username = request.getHeader("username");
		if (token == null || username == null || !tokenService.isValidToken(username, token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Invalid or missing token");
			return false;
		}                        

		// Token is valid, proceed with request
		return true;
	}
}