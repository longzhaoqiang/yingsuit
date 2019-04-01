package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.mapper.TProductMapper;
import com.yingsu.newbuss.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private TProductMapper productMapper;

    @Override
    public ResultBase addProduct(TProduct product) {
        ResultBase resultBase = new ResultBase();
        Integer result = productMapper.insertSelective(product);
        if (result < 1){
            resultBase.setResultCode("-1");
            resultBase.setResultMsg("插入数据失败!");
        }
        return resultBase;
    }
}
