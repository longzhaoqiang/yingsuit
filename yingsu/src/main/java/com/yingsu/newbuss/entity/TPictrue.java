package com.yingsu.newbuss.entity;

import java.util.Date;

public class TPictrue {
    private Integer id;

    private String pictrueUrl;

    // 商品id
    private String productId;

    // 图片类型默认为0=商品详情图
    private Integer pictrueType = 0;

    // 默认为当前时间
    private Date createTime = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictrueUrl() {
        return pictrueUrl;
    }

    public void setPictrueUrl(String pictrueUrl) {
        this.pictrueUrl = pictrueUrl == null ? null : pictrueUrl.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getPictrueType() {
        return pictrueType;
    }

    public void setPictrueType(Integer pictrueType) {
        this.pictrueType = pictrueType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}