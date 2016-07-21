/**
 * Copyright (c) 2015-2015 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easyshop.common.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.common.module.mybatis.plugin.PageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easyshop.common.web.Constants;

/**
 * @description 设置通用数据
 * @author ywu@wuxicloud.com
 * 2015年4月28日 下午3:57:20
 */
public class SetCommonDataFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SetCommonDataFilter.class);
	
	/**
	 * web资源根路径
	 */
	private static String webBase = null;
	/**
	 * 分页参数当前页参数名
	 */
	private static String currentPageParamKey = Constants.CURRENT_PAGE_KEY;
	/**
	 * 翻页参数每页显示记录数参数名
	 */
	private static String pageSizeParamKey = Constants.PAGE_SIZE_KEY;

	public void init(FilterConfig filterConfig) throws ServletException {
		webBase = filterConfig.getInitParameter(Constants.WEB_BASE);
		
		String currentPageParamName = filterConfig.getInitParameter(Constants.CURRENT_PAGE_KEY);
		if (StringUtils.isNotBlank(currentPageParamName)) {
			currentPageParamKey = currentPageParamName;
		}
		
		String pageSizeParamName = filterConfig.getInitParameter(Constants.PAGE_SIZE_KEY);
		if (StringUtils.isNotBlank(pageSizeParamName)) {
			pageSizeParamKey = pageSizeParamName;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//上下文路径
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		if(request.getAttribute(Constants.CONTEXT_PATH) == null){
			request.setAttribute(Constants.CONTEXT_PATH, httpServletRequest.getContextPath());
		}
		if(request.getAttribute(Constants.WEB_BASE) == null){
			request.setAttribute(Constants.WEB_BASE, webBase);
		}
		
		//分页参数
		String currentPageStr = request.getParameter(currentPageParamKey);
		if (StringUtils.isNotBlank(currentPageStr)) {
			try {
				Integer currentPage = Integer.valueOf(currentPageStr);
				PageContext.setCurrentPage(currentPage);
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				LOGGER.warn("当前请求设置了分页'currentPage'参数,但是参数值格式不正确,参数值{}", currentPageStr);
			}
		}
		
		String pageSizeStr = request.getParameter(pageSizeParamKey);
		if (StringUtils.isNotBlank(pageSizeStr)) {
			try {
				Integer pageSize = Integer.valueOf(pageSizeStr);
				PageContext.setPageSize(pageSize);
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				LOGGER.warn("当前请求设置了分页'pageSize'参数,但是参数值格式不正确,参数值{}", pageSizeStr);
			}
		}
		
		try {
			chain.doFilter(request, response);
		} finally {
			PageContext.clear();
		}
	}

	public void destroy() {
		//do nothing
	}
	
}
