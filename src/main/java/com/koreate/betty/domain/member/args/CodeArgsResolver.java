package com.koreate.betty.domain.member.args;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeArgsResolver implements HandlerMethodArgumentResolver{
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		 log.info("code args resovler call");
	     boolean hasCodeAnno = parameter.hasParameterAnnotation(Code.class);
	     boolean hasString = String.class.isAssignableFrom(parameter.getParameterType());
	     return hasCodeAnno && hasString;
	}
	
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		 	HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
	        HttpSession session = request.getSession(false);
	        if(session == null) return null;
	        
	        String code = (String)session.getAttribute("code");
	        return code;
	}


}
