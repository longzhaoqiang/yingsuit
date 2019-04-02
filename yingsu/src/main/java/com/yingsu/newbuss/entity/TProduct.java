package com.yingsu.newbuss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TProduct {
    private String id;

    private String productId;

    private String productName;

    private Integer commodityId;

    private Integer pictrueId;

    private BigDecimal price;

    private Integer productNum;

    private String bussAddress;

    private String sendRange;

    private String productDetails;

    private Date createTime = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getPictrueId() {
        return pictrueId;
    }

    public void setPictrueId(Integer pictrueId) {
        this.pictrueId = pictrueId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBussAddress() {
        return bussAddress;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public void setBussAddress(String bussAddress) {
        this.bussAddress = bussAddress == null ? null : bussAddress.trim();
    }

    public String getSendRange() {
        return sendRange;
    }

    public void setSendRange(String sendRange) {
        this.sendRange = sendRange == null ? null : sendRange.trim();
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}