/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>商品分类
 * @author auto generated
 * @since 2016-06-12 17:59:08
 */
public class Category extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 分类id
	 */
	private Long id;
	/**
	 * 父分类id
	 */
	private Long pid;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 是否是父分类,1:是,0:否
	 */
	private Integer isParent;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date lastUpdate;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
