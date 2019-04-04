package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IProductService;
import com.yingsu.newbuss.util.Constant;
import com.yingsu.newbuss.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    /**
     * 添加商品
     * @param product
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultBase addProduct(HttpSession session, TProduct product){
        ResultBase resultBase = new ResultBase();
        String key = "no-repeat-addProduct";
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        if (user != null) {
            Integer bussId = user.getBussId();
            product.setBussId(bussId);
        }
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

    /**
     * 根据类型获取商品列表
     * @param productStatus
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public ResultBase getProductList(HttpSession session,Integer productStatus,Integer timeStatus,Integer isUse,Integer bussId){
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = productService.getProductList(session, productStatus,timeStatus,isUse,bussId);
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
    }
}
