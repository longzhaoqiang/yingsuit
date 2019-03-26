package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/yingsu/user")
public class UserControler {

    @Autowired
    IUserService userService;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    /**
     * 登录时跳转
     * @return
     */
    @RequestMapping("/login")
    public String login(){

        return "user/login";
    }

    /**
     * 登录时查数据库
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public ResultBase userLogin(String mobile,String password){
        ResultBase resultBase = new ResultBase();
        try {
            TUser user = userService.userLogin(mobile,password);
            if (user == null){
                resultBase.setResultCode("-101");
                resultBase.setResultMsg("用户名或密码错误，请输入正确的用户名及密码！");
            }
        }catch (Exception e){
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("系统异常！");
        }

        return resultBase;
    }

    /**
     * 注册时到数据库
     */
    @RequestMapping("/userRegister")
    @ResponseBody
    public ResultBase userRegister(String mobile,String password){
        ResultBase resultBase = new ResultBase();
        try {
            boolean flag = userService.getUserInfo(mobile);
            // 如果注册状态为true
            if (flag){
                resultBase.setResultCode("-100");
                resultBase.setResultMsg("你已注册过了，请直接登录！");
            } else {
                Integer result = userService.userRegister(mobile,password);
                if (result != 1){
                    resultBase.setResultCode("-101");
                    resultBase.setResultMsg("系统异常！");
                }
            }
        }catch (Exception e){
            System.out.println(e);
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
    }

    /**
     * 注册时跳转
     */
    @RequestMapping("/register")
    public String register(){
        System.out.println("register");
        return "user/register";
    }
}
