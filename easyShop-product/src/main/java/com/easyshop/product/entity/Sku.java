/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>sku
 * @author auto generated
 * @since 2016-06-12 17:59:08
 */
public class Sku extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * sku编码
	 */
	private String partnumber;
	/**
	 * sku条形码
	 */
	private String barcode;
	/**
	 * 数量
	 */
	private Integer number;
	/**
	 * 吊牌价
	 */
	private Double listPrice;
	/**
	 * 销售价
	 */
	private Double offerPrice;
	/**
	 * 状态
	 */
	private Integer status;
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

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getPartnumber() {
		return this.partnumber;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getOfferPrice() {
		return this.offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
