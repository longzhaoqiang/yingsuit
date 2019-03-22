package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.mapper.TBussesserMapper;
import com.yingsu.newbuss.service.IBussesserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BussesserServiceImpl implements IBussesserService {

    @Autowired
    private TBussesserMapper bussesserMapper;

    @Override
    public TBussesser getBussersser(Integer bussesserId) {
        TBussesser bussesser = bussesserMapper.selectByPrimaryKey(bussesserId);
        return bussesser;
    }
}
