package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TCatagory;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.mapper.TBussesserMapper;
import com.yingsu.newbuss.mapper.TCatagoryMapper;
import com.yingsu.newbuss.service.IBussesserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussesserServiceImpl implements IBussesserService {

    @Autowired
    private TBussesserMapper bussesserMapper;

    @Autowired
    private TCatagoryMapper catagoryMapper;

    /**
     * 获取商家信息
     * @param bussesserId
     * @return
     */
    @Override
    public TBussesser getBussersser(Integer bussesserId) {
        TBussesser bussesser = bussesserMapper.selectByPrimaryKey(bussesserId);
        return bussesser;
    }

    @Override
    public TBussesser getBussInfo(Integer userId) {
        TBussesser bussesser = bussesserMapper.selectByUid(userId);
        return bussesser;
    }

    /**
     * 获取分类信息列表
     */
    @Override
    public ResultBase getCatagoryList() {
        ResultBase resultBase = new ResultBase();
        List<TCatagory> catagoryList = catagoryMapper.findCatagoryList();
        if (catagoryList.size() > 1){
            resultBase.setObject(catagoryList);
        } else {
            resultBase.setResultCode("100");
            resultBase.setResultMsg("暂无数据");
        }
        return resultBase;
    }

    /**
     * 商家注册
     * @param bussesser
     * @return
     */
    @Override
    public ResultBase addBussesser(TBussesser bussesser) {
        ResultBase resultBase = new ResultBase();
        Integer result = bussesserMapper.insertSelective(bussesser);
        if (result == 1){
            return resultBase;
        }
        resultBase.setResultCode("-104");
        resultBase.setResultCode("插入数据失败");
        return resultBase;
    }
}
