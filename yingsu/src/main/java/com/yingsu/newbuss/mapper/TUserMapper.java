package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TUser;

public interface TUserMapper {

    // 通过手机号码查找用户
    TUser selectByMobile(String mobile);

    // 用户登录
    TUser userLogin(String mobile,String password);

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}