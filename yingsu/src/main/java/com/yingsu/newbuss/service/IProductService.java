package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.base.ResultBase;

public interface IProductService {
    // 添加一个商品接口
    ResultBase addProduct(TProduct product);

}
