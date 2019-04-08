package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;

import javax.servlet.http.HttpSession;

public interface IUserService {
    // 通过手机号查看用户信息
    boolean getUserInfo(String mobile);

    // 注册
    // 注册属于插入类型，只要返回插入状态成功或者失败，用0,1表示就行，类型用Integer
    Integer userRegister(String mobile,String password);

    // 用户登录
    // 因为登录要查询用户名和密码，属于查询，要返回一个实体类或者集合来保存用户信息
    TUser userLogin(String mobile,String password);

    /**
     * 修改密码前查找老密码是否正确
     * @param oldPassword
     * @return
     */
    ResultBase resetPw_1(HttpSession session, String oldPassword, String newPassword);
}
