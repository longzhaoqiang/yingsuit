package com.yingsu.newbuss.service;

import com.yingsu.newbuss.entity.TUser;

public interface IUserService {
    // 通过手机号查看用户信息
    boolean getUserInfo(String mobile);

    // 注册
    Integer userRegister(String mobile,String password);

    // 用户登录
    TUser userLogin(String mobile,String password);
}
