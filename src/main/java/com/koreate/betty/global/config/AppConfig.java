package com.koreate.betty.global.config;

import java.time.Duration;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.koreate.betty.domain.member.resolver.LoginArgumentResolver;
import com.koreate.betty.example.TempInterceptor;


/**
 * 
 * @author namu6747
 * FrontController 역할을 맡는 프로젝트 내 단 하나의 Servlet
 * Servlet 관련 다양한 설정과 빈을 등록할 수 있음.
 */

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
		//registry.addFormatter(new TempFormatter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TempInterceptor())
		.order(1)
		.addPathPatterns("/**");
		//.excludePathPatterns("/css/**","/*.ico", "/error", "/error-page/**");
	}

	// 정적 자원에 대한 요청 경로와 자원의 위치를 지정하는 역할
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));;
		}
	
	// 매개 변수의 인자로 들어온 데이터를 검증하는 역할
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		 resolvers.add(new LoginArgumentResolver());
	}

	// Inter
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//registry.enableContentNegotiation(new MappingJackson2JsonView());
		//registry.enableContentNegotiation(viewResolver);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
		//registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
    /*@Bean
    public ViewResolver viewResolver() {
       
        
        return viewResolver;
    }*/
	
	
}
