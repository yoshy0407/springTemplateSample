package com.example.demo.template.mvc.method.annotation;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.demo.template.annotation.Paging;
import com.example.demo.template.paging.Page;

public class PagingHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private final String defaultRequestAttr;

	private final int defaultPagePerSize;
	
	public PagingHandlerMethodArgumentResolver(
			String defaultRequestAttr,
			int defaultPagePerSize) {
		this.defaultRequestAttr = defaultRequestAttr;
		this.defaultPagePerSize = defaultPagePerSize;
	}
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Page.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String requestAttr = null;
		int pagePerSize = -1;
		if (parameter.hasParameterAnnotation(Paging.class)) {
			Paging paging = parameter.getMethodAnnotation(Paging.class);
			requestAttr = getRequestAttr(paging);
			pagePerSize = getPagePerSize(paging);
		} else {
			requestAttr = defaultRequestAttr;
			pagePerSize = defaultPagePerSize;
		}
		
		Object value = webRequest.getParameter(requestAttr);
		if (value == null) {
			return new Page(1, pagePerSize);
		} else {
			int pageNo = Integer.parseInt(value.toString());
			return new Page(pageNo, pagePerSize);
		}
	}

	private String getRequestAttr(Paging paging) {
		if (StringUtils.hasLength(paging.requestAttr())) {
			return paging.requestAttr();
		} else {
			return defaultRequestAttr;
		}
	}
	
	private int getPagePerSize(Paging paging) {
		if (paging.pagePerSize() != Paging.DEFAULT_PAGE_PER_SIZE) {
			return paging.pagePerSize();
		} else {
			return defaultPagePerSize;
		}
	}
	
}
