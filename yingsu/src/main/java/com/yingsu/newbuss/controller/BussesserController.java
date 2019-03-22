package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IBussesserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yingsu/buss")
public class BussesserController {

    @Autowired
    private IBussesserService bussesserService;

    @RequestMapping("/getBussesser")
    public ResultBase getBussesser(Integer bussesserId){
        TBussesser tBussesser = null;
        ResultBase resultBase = new ResultBase();
        try {
            tBussesser = bussesserService.getBussersser(bussesserId);
            resultBase.setObject(tBussesser);
        }catch (Exception e){
            resultBase.setResultCode("100");
            resultBase.setResultMsg("系统异常" + e);
        }

        return resultBase;
    }
}
