package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.base.ResultBase;

import javax.servlet.http.HttpSession;

public interface IProductService {
    /**
     * 添加一个商品接口
     * @param product
     * @return
     */
    ResultBase addProduct(TProduct product);

    /**
     * 根据类型获取商品列表接口
     * @param productStatus
     * @return
     */
    ResultBase getProductList(HttpSession session, Integer productStatus, Integer timeStatus, Integer isUse, Integer bussId);
}
