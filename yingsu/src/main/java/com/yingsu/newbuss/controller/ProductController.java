package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IProductService;
import com.yingsu.newbuss.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品Controller
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultBase addProduct(TProduct product){
        ResultBase resultBase = new ResultBase();
        String key = "no-repeat-addProduct";
        boolean flag = redisService.exists(key);
        try {
            if(!flag){
                // 一秒内防止重复提交
                redisService.set(key,1,1L);
            } else {
                resultBase.setResultCode("-102");
                resultBase.setResultMsg("请勿重复提交！");
                return resultBase;
            }
            product.setId(product.getProductId());
            resultBase = productService.addProduct(product);
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
    }
}
