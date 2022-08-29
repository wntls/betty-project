package com.koreate.betty.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChooseNavInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String path = request.getServletContext().getContextPath();
		if(uri.split("/").length >= 3) {
			String nav = uri.split("/")[2];
			request.setAttribute("nav", nav);
		}
		return true;
	}

	
	
}
