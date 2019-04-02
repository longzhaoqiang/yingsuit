package com.yingsu.newbuss.service.impl;

import com.yingsu.newbuss.entity.TPictrue;
import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.mapper.TPictrueMapper;
import com.yingsu.newbuss.mapper.TProductMapper;
import com.yingsu.newbuss.service.IFileUploadService;
import com.yingsu.newbuss.util.Constant;
import com.yingsu.newbuss.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Autowired
    private TPictrueMapper pictrueMapper;

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public String uploadPictrue(HttpSession session, String pictrueUrl) {
        String productId = "f9550f8a-9842-4024-95f2-";
        TPictrue pictrue = new TPictrue();
        Long time = new Date().getTime()/10000;
        TUser user = (TUser) session.getAttribute(Constant.USER_INFO);
        productId += user.getId() + "--" + time;
        pictrue.setPictrueUrl(pictrueUrl);
        // 创建商品id，商品插入数据时的id从这儿生成，必须图片上传成功才能插入商品数据
        pictrue.setProductId(productId);
        Integer result = pictrueMapper.insertSelective(pictrue);
        if (result > 0){
            return productId;
        } else {
            return "-1";
        }

    }
}
