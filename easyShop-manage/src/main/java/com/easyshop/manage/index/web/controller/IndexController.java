/**
 * Copyright (c) 2015-2016 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easyshop.manage.index.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 首页
 * @author ywu@wuxicloud.com
 * 2016年1月17日 下午4:48:10
 */
@RequestMapping("system/")
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("calendar")
	public String calendar() {
		return "common/calendar";
	}
}
