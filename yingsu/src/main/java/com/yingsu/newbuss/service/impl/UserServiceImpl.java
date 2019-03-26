package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.mapper.TUserMapper;
import com.yingsu.newbuss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    TUserMapper userMapper;

    /**
     * 通过手机号查看用户信息
     * @param mobile
     * @return
     */
    @Override
    public boolean getUserInfo(String mobile) {
        boolean flag = false;
        TUser user = userMapper.selectByMobile(mobile);
        if (user != null){
            flag = true;
        }
        return flag;
    }

    /**
     * 注册
     * @param mobile
     * @param password
     * @return
     */
    @Override
    public Integer userRegister(String mobile, String password) {
        TUser user = new TUser();
        user.setMobile(mobile);
        user.setPassword(password);
        Integer result = userMapper.insert(user);
        return result;
    }

    /**
     * 用户登录
     * @param mobile
     * @param password
     * @return
     */
    @Override
    public TUser userLogin(String mobile, String password) {
        TUser user = userMapper.userLogin(mobile,password);
        return user;
    }
}
