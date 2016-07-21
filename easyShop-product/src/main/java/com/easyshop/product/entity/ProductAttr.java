/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>商品属性
 * @author auto generated
 * @since 2016-06-12 17:59:08
 */
public class ProductAttr extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 商品
	 */
	private Long productId;
	/**
	 * 属性id
	 */
	private Long attrId;
	/**
	 * 属性名称
	 */
	private String attrName;
	/**
	 * 属性值
	 */
	private String value;
	/**
	 * 是否销售属性,1:是,0:否
	 */
	private Integer isSale;
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

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getIsSale() {
		return this.isSale;
	}

	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
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
