/**
 * Apache License 2.0
 */
package com.easyshop.product.entity;

import org.common.module.entity.BaseEntity;

import java.util.Date;

/**
 * <p>商品
 * @author auto generated
 * @since 2016-06-12 17:59:08
 */
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键(CATENTRY_ID)
	 */
	private Long id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商家编码
	 */
	private String partnumber;
	/**
	 * 条形码
	 */
	private String barcode;
	/**
	 * 品牌id
	 */
	private Integer brandId;
	/**
	 * 分类id
	 */
	private Long categoryId;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 关键词
	 */
	private String keywords;
	/**
	 * 商品链接
	 */
	private String url;
	/**
	 * 主图链接
	 */
	private String picUrl;
	/**
	 * 数量
	 */
	private Integer number;
	/**
	 * 是否可购买
	 */
	private Integer buyable;
	/**
	 * 运费支付方式
	 */
	private Integer freightPayType;
	/**
	 * 运费模板
	 */
	private Long postageId;
	/**
	 * 状态(默认0,1:上架,2:下架)
	 */
	private Integer status;
	/**
	 * 积分返点比例
	 */
	private Integer auctionPoint;
	/**
	 * 库存扣减方式,0:拍下,1:付款
	 */
	private Integer subStock;
	/**
	 * 吊牌价
	 */
	private Double listPrice;
	/**
	 * 销售价
	 */
	private Double offerPrice;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getBuyable() {
		return this.buyable;
	}

	public void setBuyable(Integer buyable) {
		this.buyable = buyable;
	}

	public Integer getFreightPayType() {
		return this.freightPayType;
	}

	public void setFreightPayType(Integer freightPayType) {
		this.freightPayType = freightPayType;
	}

	public Long getPostageId() {
		return this.postageId;
	}

	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAuctionPoint() {
		return this.auctionPoint;
	}

	public void setAuctionPoint(Integer auctionPoint) {
		this.auctionPoint = auctionPoint;
	}

	public Integer getSubStock() {
		return this.subStock;
	}

	public void setSubStock(Integer subStock) {
		this.subStock = subStock;
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
