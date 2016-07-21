/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>商品列表图
 * @author auto generated
 * @since 2016-06-12 17:59:08
 */
public class ProductImage extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 图片id
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * URL
	 */
	private String url;
	/**
	 * 位置
	 */
	private Integer position;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
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
