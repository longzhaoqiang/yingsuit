package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TCatagory;

public interface TCatagoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCatagory record);

    int insertSelective(TCatagory record);

    TCatagory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCatagory record);

    int updateByPrimaryKey(TCatagory record);
}