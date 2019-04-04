package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TProduct;
import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.mapper.TProductMapper;
import com.yingsu.newbuss.service.IProductService;
import com.yingsu.newbuss.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private TProductMapper productMapper;

    /**
     * 添加一个商品接口
     * @param product
     * @return
     */
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

    /**
     * 根据类型获取商品列表接口
     * @param productStatus
     * @return
     */
    @Override
    public ResultBase getProductList(HttpSession session, Integer productStatus, Integer timeStatus, Integer isUse, Integer bussId) {
        if (bussId == null){
            TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
            bussId = user.getBussId();
        }
        ResultBase resultBase = new ResultBase();
        List<TProduct> productList = new ArrayList<>();
        // 未下架的
        productList = productMapper.selectListByIsUse(productStatus, timeStatus,isUse,bussId);
        resultBase.setObject(productList);
        if (productList.size() < 1){
            resultBase.setResultCode("101");
            resultBase.setResultMsg("没有数据!");
        }
        return resultBase;
    }
}
