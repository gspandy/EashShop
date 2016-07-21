/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easyshop.common.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
/**
 * @description 全局日期转换器
 * @author ywu@wuxicloud.com
 * 2016年2月3日 上午9:55:37
 */
public class DateConverter implements WebBindingInitializer {
	/**
	 * 日期格式
	 */
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(this.pattern), true));
	}

}
