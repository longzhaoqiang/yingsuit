package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TCommunity;

public interface TCommunityMapper {
    int insert(TCommunity record);

    int insertSelective(TCommunity record);
}