package com.koreate.betty.global.config;

import java.time.Duration;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.koreate.betty.domain.member.resolver.LoginArgumentResolver;
import com.koreate.betty.example.TempFormatter;
import com.koreate.betty.example.TempInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@EnableWebMvc
@EnableScheduling
@EnableAspectJAutoProxy
@ComponentScan( basePackages = { "com.koreate.betty" }, 
				excludeFilters = @ComponentScan.Filter(
								type = FilterType.ANNOTATION,
								classes = Configuration.class
								)
			)
public class AppConfig implements WebMvcConfigurer {

	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new TempFormatter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TempInterceptor())
		.order(1)
		.addPathPatterns("/**");
		//.excludePathPatterns("/css/**","/*.ico", "/error", "/error-page/**");
	}

	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));;
		}
	

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		 resolvers.add(new LoginArgumentResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
}
