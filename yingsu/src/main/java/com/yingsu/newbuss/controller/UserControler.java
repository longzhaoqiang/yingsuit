package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TBussesser;
import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IBussesserService;
import com.yingsu.newbuss.service.IUserService;
import com.yingsu.newbuss.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/yingsu/user")
public class UserControler {

    @Autowired
    IUserService userService;

    @Autowired
    IBussesserService bussesserService;

    Integer i = 10;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session, String name) {
        ModelAndView view = new ModelAndView("user/index");
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        if (user != null) {
            Integer bussId = user.getBussId();
            view.addObject("bussId", bussId);
        }
        return view;
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
     * 注册时跳转
     */
    @RequestMapping("/register")
    public String register(){
        return "user/register";
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
            TBussesser buss = null;
            if (user != null) {
                buss = bussesserService.getBussInfo(user.getId());
                if (buss != null){
                    user.setBussId(buss.getId());
                }
            }
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
            resultBase.setResultMsg("系统异常！" + e);
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
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
    }

    /**
     * 重置密码查询老密码是否正确
     * @param oldPassword
     * @return
     */
    @RequestMapping("/reSetPw_1")
    @ResponseBody
    public ResultBase reSetPw(HttpSession session, String oldPassword, String newPassword){
        ResultBase resultBase = new ResultBase();
        try {
            TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
            if (user != null) {
                resultBase = userService.resetPw_1(session, oldPassword, newPassword);
            } else {
                resultBase.setResultCode("-101");
                resultBase.setResultCode("");
            }
        }catch (Exception e){
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("系统异常！");
        }
        return resultBase;
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

    /**
     * 检查是否登录
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public ResultBase checkLogin(HttpSession session){
        ResultBase resultBase = new ResultBase();
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        if (user == null){
            resultBase.setResultCode("-12");
            resultBase.setResultMsg("登录失效，请重新登录！");
        }
        return resultBase;
    }
}
