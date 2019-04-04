package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductMapper {

    /**
     * 根据商品状态查找
     * @param productStatus
     * @return
     */
    List<TProduct> selectListByIsUse(Integer productStatus,Integer timeStatus,Integer isUse,Integer bussId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);
}