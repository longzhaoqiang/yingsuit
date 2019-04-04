package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IBussesserService;
import com.yingsu.newbuss.util.Constant;
import com.yingsu.newbuss.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/yingsu/buss")
public class BussesserController {

    @Autowired
    private IBussesserService bussesserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/getBussesser")
    public ResultBase getBussesser(Integer bussesserId){
        TBussesser tBussesser = null;
        ResultBase resultBase = new ResultBase();
        try {
            tBussesser = bussesserService.getBussersser(bussesserId);
            resultBase.setObject(tBussesser);
        }catch (Exception e){
            resultBase.setResultCode("100");
            resultBase.setResultMsg("系统异常");
        }

        return resultBase;
    }

    // 获取分类信息列表
    @RequestMapping("/getCatagoryList")
    @ResponseBody
    public ResultBase getCatagoryList(){
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = bussesserService.getCatagoryList();
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常");
        }
        return resultBase;
    }

    // 添加商家
    @RequestMapping("/addbuss")
    @ResponseBody
    public ResultBase addbuss(HttpSession session, TBussesser bussesser){
        ResultBase resultBase = new ResultBase();
        try {
            TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
            Integer userId = (Integer) user.getId();
            bussesser.setUserId(userId);
            resultBase = bussesserService.addBussesser(bussesser);
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常");
        }
        return resultBase;
    }

}
