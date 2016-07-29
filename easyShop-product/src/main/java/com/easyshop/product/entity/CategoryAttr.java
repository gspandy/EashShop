/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>类目属性
 * @author auto generated
 * @since 2016-07-28 17:13:31
 */
public class CategoryAttr extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 类目id
	 */
	private Long categoryId;
	/**
	 * 类目名称
	 */
	private String categoryName;
	/**
	 * 属性id
	 */
	private Long attrId;
	/**
	 * 属性名称
	 */
	private String attrName;
	/**
	 * 是否必须,1:是,0:否
	 */
	private Integer required;
	/**
	 * 是否销售属性
	 */
	private Integer isSale;
	/**
	 * 是否颜色
	 */
	private Integer isColor;
	/**
	 * 扩展字段1
	 */
	private String field1;
	/**
	 * 扩展字段2
	 */
	private String field2;
	/**
	 * 扩展字段3
	 */
	private Integer field3;
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

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public Integer getRequired() {
		return this.required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}

	public Integer getIsSale() {
		return this.isSale;
	}

	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}

	public Integer getIsColor() {
		return this.isColor;
	}

	public void setIsColor(Integer isColor) {
		this.isColor = isColor;
	}

	public String getField1() {
		return this.field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public Integer getField3() {
		return this.field3;
	}

	public void setField3(Integer field3) {
		this.field3 = field3;
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
