package com.geonoon.xing.util.stetho;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 
 *
 * @author: Marc SUN
 * @email: 710641245@qq.com
 * @created: 17-8-18 下午4:59
 * 
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {}
