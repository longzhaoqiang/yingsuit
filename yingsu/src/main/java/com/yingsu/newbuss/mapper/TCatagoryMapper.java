package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TCatagory;

import java.util.List;

public interface TCatagoryMapper {

    /**
     * 获取行业分类列表
     * @return
     */
    List<TCatagory> findCatagoryList();

    int insert(TCatagory record);

    int insertSelective(TCatagory record);

    TCatagory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCatagory record);

    int updateByPrimaryKey(TCatagory record);
}