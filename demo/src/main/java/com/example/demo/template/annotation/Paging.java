package com.example.demo.template.annotation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(CLASS)
@Target(PARAMETER)
public @interface Paging {

	public static final int DEFAULT_PAGE_PER_SIZE = -1;
	
	String requestAttr() default "";
	
	int pagePerSize() default DEFAULT_PAGE_PER_SIZE;
}
