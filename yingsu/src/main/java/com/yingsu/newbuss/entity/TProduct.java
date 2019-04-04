package com.yingsu.newbuss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TProduct {
    private String id;

    private String productId;

    private String productName;

    private Integer bussId;

    private Integer commodityId;

    private BigDecimal price;

    private Integer productNum;

    private String bussAddress;

    private String sendRange;

    private String productDetails;

    private Integer isTimegoods;

    private Integer isUse;

    private Integer isDelete;

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

    public Integer getBussId() {
        return bussId;
    }

    public void setBussId(Integer bussId) {
        this.bussId = bussId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
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

    public Integer getIsTimegoods() {
        return isTimegoods;
    }

    public void setIsTimegoods(Integer isTimegoods) {
        this.isTimegoods = isTimegoods;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}