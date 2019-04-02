package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TVocation;

import java.util.List;

public interface TVocationMapper {

    /**
     * 获取行业分类列表
     * @return
     */
    List<TVocation> findVocatList();

    int insert(TVocation record);

    int insertSelective(TVocation record);

    TVocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TVocation record);

    int updateByPrimaryKey(TVocation record);
}