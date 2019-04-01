package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品Controller
 */
@RestController
@RequestMapping("/product")
public class ProduceController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/add")
    public ResultBase addProduct(TProduct product){
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = productService.addProduct(product);
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
    }
}
