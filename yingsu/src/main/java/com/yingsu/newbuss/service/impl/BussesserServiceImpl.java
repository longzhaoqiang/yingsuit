package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TVocation;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.mapper.TBussesserMapper;
import com.yingsu.newbuss.mapper.TVocationMapper;
import com.yingsu.newbuss.service.IBussesserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussesserServiceImpl implements IBussesserService {

    @Autowired
    private TBussesserMapper bussesserMapper;

    @Autowired
    private TVocationMapper vocationMapper;

    @Override
    public TBussesser getBussersser(Integer bussesserId) {
        TBussesser bussesser = bussesserMapper.selectByPrimaryKey(bussesserId);
        return bussesser;
    }

    @Override
    public ResultBase getVacatList() {
        ResultBase resultBase = new ResultBase();
        List<TVocation> vocationList = vocationMapper.findVocatList();
        if (vocationList.size() > 1){
            resultBase.setObject(vocationList);
        } else {
            resultBase.setResultCode("100");
            resultBase.setResultMsg("暂无数据");
        }
        return resultBase;
    }
}
