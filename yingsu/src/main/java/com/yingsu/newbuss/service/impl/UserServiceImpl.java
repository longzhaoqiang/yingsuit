package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.mapper.TUserMapper;
import com.yingsu.newbuss.service.IUserService;
import com.yingsu.newbuss.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
    // 方法两个参数接受controller传来的信息，也是前端传来的信息
    @Override
    public TUser userLogin(String mobile, String password) {
        // 调用mapper操作数据库的方法，按ctrl+左键进入，这是一个查询用户信息的方法，所以返回用户实体类，可看用户实体类字段
        TUser user = userMapper.userLogin(mobile,password);
        // 返回给controller
        return user;
    }

    /**
     * 修改密码前查找老密码是否正确
     * @param oldPassword
     * @return
     */
    @Override
    public ResultBase resetPw_1(HttpSession session, String oldPassword, String newPassword) {
        ResultBase resultBase = new ResultBase();
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        String mobile = user.getMobile();
        // 通过旧密码查询看输入的旧密码是否正确
        TUser user1 =  userMapper.userLogin(mobile,oldPassword);
        if (user1 == null){
            resultBase.setResultCode("-101");
            resultBase.setResultMsg("旧密码不正确，请重新输入");
        } else {
            user.setPassword(newPassword);
            Integer result = userMapper.updateByPrimaryKeySelective(user);
            if (result != 1){
                resultBase.setResultCode("-101");
                resultBase.setResultMsg("系统异常，请稍后再试");
            }
        }
        return resultBase;
    }
}
