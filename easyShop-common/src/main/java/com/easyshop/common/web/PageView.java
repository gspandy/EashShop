/**
 * Copyright (c) 2015-2015 yejunwu126@126.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.easyshop.common.web;

import java.util.List;

import org.common.module.entity.query.Page;

/**
 * @description 分页显示数据,便于转换成json格式
 * @author ywu@wuxicloud.com
 * 2015年5月15日 下午10:43:53
 */
public class PageView {
	
	public PageView(Page page) {
		setTotal(page.getTotalPage());
		setRecords(page.getTotalRecords());
		setRows(page.getData());
	}
	/**
	 * 总页数
	 */
	private int total;
	/**
	 * 总记录数
	 */
	private long records;
	/**
	 * 数据
	 */
	private List<?> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	
}
