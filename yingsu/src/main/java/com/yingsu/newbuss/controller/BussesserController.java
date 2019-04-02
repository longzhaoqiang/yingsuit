package com.yingsu.newbuss.controller;

import com.sun.deploy.net.HttpResponse;
import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TVocation;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IBussesserService;
import com.yingsu.newbuss.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        // 设置一个键
        String key = "1111111";
        // redis
        // 查看redis是否有key="1111111"这个key对应的值
        boolean flag = redisService.exists(key);
        try {
            // 如果flag是true(reids有值)
            if(flag){
                // 到redis取（通过get方法把key传进去）
                String s = (String) redisService.get(key);
            } else {
                // 如果没有，从数据库查
                tBussesser = bussesserService.getBussersser(bussesserId);
                // 查到后放到rides(调用set方法，set(key,value,expierTime),对应的是键，值，过期时间)
                // 设置完后，下次程序从上面走上来就调exists()方法查就有了
                redisService.set(key, tBussesser, 6000L);
                resultBase.setObject(tBussesser);
            }
        }catch (Exception e){
            resultBase.setResultCode("100");
            resultBase.setResultMsg("系统异常");
        }

        return resultBase;
    }

    // 获取分类信息列表
    @RequestMapping("/getVacatList")
    @ResponseBody
    public ResultBase getVacatList(){
        ResultBase resultBase = new ResultBase();
        try {
            resultBase = bussesserService.getVacatList();
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常");
        }
        return resultBase;
    }

    // 添加商家
    @RequestMapping("/addbuss")
    @ResponseBody
    public ResultBase addbuss(TBussesser bussesser){
        ResultBase resultBase = new ResultBase();
        try {
            // resultBase = bussesserService.getVacatList();
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常");
        }
        return resultBase;
    }

}
