package com.demo;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Column {
	public String value() default "";
	public boolean nullable() default true;
	public int length() default -1;
}
