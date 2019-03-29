package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IUserService;
import com.yingsu.newbuss.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public ResultBase userLogin(HttpSession session, String mobile, String password){
        // new一个返回到前端的自定义对象，返回时会变成json格式，可ctrl+左键进入看字段类型
        ResultBase resultBase = new ResultBase();
        // 处理前先try...catch，万一有异常
        try {
            // 调用service层，通过接口的注入调用实现类的方法，userService就是接口注入的引用，userLogin(mobile,password)实现类的方法
            // 程序走到这里会进入service层，按ctrl+左键进入，service执行完会回到这里
            TUser user = userService.userLogin(mobile,password);
            if (user == null){
                // 判断查出来的结果，给返回对象修改返回值
                resultBase.setResultCode("-101");
                resultBase.setResultMsg("用户名或密码错误，请输入正确的用户名及密码！");
            } else {
                session.setAttribute(Constant.USER_INFO,user);
            }
        }catch (Exception e){
            // 如果有异常，也给返回对象修改返回值
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("系统异常！"+e);
        }
        // 返回到前端
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
        return "user/register";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/loginout")
    @ResponseBody
    public ResultBase loginOut(HttpSession session){
        ResultBase resultBase = new ResultBase();
        session.removeAttribute(Constant.USER_INFO);
        return resultBase;
    }
}
