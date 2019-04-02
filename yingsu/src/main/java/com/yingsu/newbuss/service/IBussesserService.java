package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TVocation;
import com.yingsu.newbuss.entity.base.ResultBase;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBussesserService {
    /**
     * 获取商家信息
     * @param bussesserId
     * @return
     */
    TBussesser getBussersser(Integer bussesserId);

    /**
     * 获取分类信息列表
     */
    ResultBase getVacatList();
}
