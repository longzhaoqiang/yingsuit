package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TBussesser;
import org.springframework.stereotype.Repository;

@Repository
public interface TBussesserMapper {
    TBussesser selectByPrimaryKey(Integer id);

    /**
     * 通过用户名查找商家信息
     * @param userId
     * @return
     */
    TBussesser selectByUid(Integer userId);

    int insert(TBussesser record);

    int insertSelective(TBussesser record);



    int updateByPrimaryKeySelective(TBussesser record);

    int updateByPrimaryKey(TBussesser record);
}