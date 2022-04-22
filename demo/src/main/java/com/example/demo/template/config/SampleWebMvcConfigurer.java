package com.example.demo.template.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.template.mvc.method.annotation.PagingHandlerMethodArgumentResolver;

@Configuration
public class SampleWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new PagingHandlerMethodArgumentResolver("page", 10));
	}

}
