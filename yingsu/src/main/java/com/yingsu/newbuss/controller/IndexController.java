package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    // 页面跳转--首页
    @RequestMapping("/")
    public String index(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/index";
    }

    // 页面跳转--分类
    @RequestMapping("/catagory")
    public String catagory(HttpSession session){
            Object object = session.getAttribute(Constant.USER_INFO);
        return "user/catagory";
    }

    // 页面跳转--发现
    @RequestMapping("/find")
    public String find(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/find";
    }

    // 页面跳转-购物车
    @RequestMapping("/cart")
    public String cart(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/cart";
    }

    // 页面跳转--我的
    @RequestMapping("/home")
    public String home(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/home";
    }

    // 页面跳转--商品详情页
    @RequestMapping("/item")
    public String item(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/item";
    }

    // 页面跳转--优惠券页
    @RequestMapping("/coupon")
    public String coupon(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/coupon";
    }

    // 页面跳转--商品页
    @RequestMapping("/goods")
    public String goods(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/goods";
    }

    // 页面跳转--添加商品页
    @RequestMapping("/addGoods")
    public String addGoods(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/addGoods";
    }

    // 页面跳转--商家详情页
    @RequestMapping("/bussesser")
    public String bussesser(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/bussess";
    }

    // 页面跳转--登录页面
    @RequestMapping("/login")
    public String login(HttpSession session){
        Object object = session.getAttribute(Constant.USER_INFO);
        return "user/login";
    }

    // 判断首页是否登录
    @RequestMapping("/index_1")
    @ResponseBody
    public ResultBase indexIsLogin(HttpSession session){
        ResultBase resultBase = new ResultBase();
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        if (user == null){
            resultBase.setResultCode("-1");
        } else {
            resultBase.setResultMsg(user.getUserName());
        }
        return resultBase;
    }

}
