package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.TUser;
import com.yingsu.newbuss.entity.base.ResultBase;
import com.yingsu.newbuss.service.IFileUploadService;
import com.yingsu.newbuss.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

/**
 * 图片上传类
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private IFileUploadService fileUploadService;

    @RequestMapping("/head")
    @ResponseBody
    @Transactional
    public ResultBase headPicUpload(HttpSession session, @RequestParam("images")MultipartFile files){
        ResultBase resultBase = new ResultBase();
        try {
            // 原始名称
            String oldFileName = files.getOriginalFilename(); // 获取上传文件的原名
            // 存储图片的虚拟本地路径（这里需要配置tomcat的web模块路径，双击猫进行配置）
            String saveFilePath = "E://picture";
            // 上传图片
            if (files != null && oldFileName != null && oldFileName.length() > 0) {
                String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
                File newFile = new File(saveFilePath + "\\" + newFileName);
                //插入数据库
                String result = fileUploadService.uploadPictrue(session,newFileName);
                // 将内存中的数据写入磁盘
                files.transferTo(newFile);
                resultBase.setResultCode(result);
            } else {
                return resultBase;
            }
        }catch (Exception e){
            resultBase.setResultCode("-100");
            resultBase.setResultMsg("系统异常！"+e);
        }
        return resultBase;
    }
}
