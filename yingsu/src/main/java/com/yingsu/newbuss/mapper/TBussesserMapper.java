package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TBussesser;
import org.springframework.stereotype.Repository;

@Repository
public interface TBussesserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBussesser record);

    int insertSelective(TBussesser record);

    TBussesser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBussesser record);

    int updateByPrimaryKey(TBussesser record);
}