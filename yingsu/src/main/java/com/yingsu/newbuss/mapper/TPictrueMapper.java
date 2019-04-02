package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TPictrue;

public interface TPictrueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TPictrue record);

    int insertSelective(TPictrue record);

    TPictrue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPictrue record);

    int updateByPrimaryKey(TPictrue record);
}