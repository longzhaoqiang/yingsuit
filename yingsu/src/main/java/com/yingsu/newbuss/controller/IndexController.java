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
        return "user/index";
    }

    // 页面跳转--分类
    @RequestMapping("/catagory")
    public String catagory(HttpSession session){
        return "user/catagory";
    }

    // 页面跳转--发现
    @RequestMapping("/find")
    public String find(HttpSession session){
        return "user/find";
    }

    // 页面跳转-购物车
    @RequestMapping("/cart")
    public String cart(HttpSession session){
        return "user/cart";
    }

    // 页面跳转--我的
    @RequestMapping("/home")
    public String home(HttpSession session){
        return "user/home";
    }

    // 页面跳转--商品详情页
    @RequestMapping("/item")
    public String item(HttpSession session){
        return "user/item";
    }

    // 页面跳转--优惠券页
    @RequestMapping("/coupon")
    public String coupon(HttpSession session){
        return "user/coupon";
    }

    // 页面跳转--商品页
    @RequestMapping("/goods")
    public String goods(HttpSession session){
        return "user/goods";
    }

    // 页面跳转--添加商品页
    @RequestMapping("/addGoods")
    public String addGoods(HttpSession session){
        return "user/addGoods";
    }

    // 页面跳转--商家详情页
    @RequestMapping("/bussesser")
    public String bussesser(HttpSession session){
        return "user/bussess";
    }

    // 页面跳转--我的信息页
    @RequestMapping("/myInfo")
    public String myInfo(HttpSession session){
        return "user/myInfo";
    }

    // 页面跳转--首页商品页
    @RequestMapping("/indexGoods")
    public String indexGoods(HttpSession session){
        return "user/indexGoods";
    }

    // 页面跳转--限时商品页
    @RequestMapping("/timeGoods")
    public String timeGoods(HttpSession session){
        return "user/timeGoods";
    }


    // 页面跳转--已下架商品页
    @RequestMapping("/noUseGoods")
    public String noUseGoods(HttpSession session){
        return "user/noUseGoods";
    }

    // 页面跳转--修改密码页
    @RequestMapping("/repassword")
    public String repassword(HttpSession session){
        return "user/repassword";
    }

    // 页面跳转--登录页面
    @RequestMapping("/login")
    public String login(HttpSession session){
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
