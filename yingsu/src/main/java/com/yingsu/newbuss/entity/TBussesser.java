package com.yingsu.newbuss.entity;

import java.util.Date;

public class TBussesser {
    private Integer id;

    private String bussesserName;

    private Integer communityId;

    private Integer catagoryId;

    private String bussAddress;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBussesserName() {
        return bussesserName;
    }

    public void setBussesserName(String bussesserName) {
        this.bussesserName = bussesserName == null ? null : bussesserName.trim();
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getBussAddress() {
        return bussAddress;
    }

    public void setBussAddress(String bussAddress) {
        this.bussAddress = bussAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}