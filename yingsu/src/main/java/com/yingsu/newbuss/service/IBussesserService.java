package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.base.ResultBase;

public interface IBussesserService {
    /**
     * 获取商家信息
     * @param bussesserId
     * @return
     */
    TBussesser getBussersser(Integer bussesserId);

    /**
     * 通过uid获取想家信息
     */
    TBussesser getBussInfo(Integer userId);

    /**
     * 获取分类信息列表
     */
    ResultBase getCatagoryList();

    /**
     * 商家注册
     */
    ResultBase addBussesser(TBussesser bussesser);

}
