package com.yingsu.newbuss.mapper;

import com.yingsu.newbuss.entity.TUser;
import org.apache.ibatis.annotations.Param;

// 去resource/mapper/.xml文件里找到跟这个类名一样的TUserMapper.xml
// 他们的匹配是类名与文件名一样，方法吗与.xml里面的操作id一个，比如<select id="selectByMobile">
public interface TUserMapper {

    // 通过手机号码查找用户
    TUser selectByMobile(String mobile);

    // 用户登录
    // 查询用户信息，然后返回，用能保存用户信息的类型来接收
    TUser userLogin(@Param("mobile") String mobile, @Param("password") String password);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}