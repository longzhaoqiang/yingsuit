package com.yingsu.newbuss.controller;

import com.yingsu.newbuss.entity.base.ResultBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @RequestMapping("/head")
    @ResponseBody
    public ResultBase headPicUpload(@RequestParam("images")MultipartFile files){
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
                // 将内存中的数据写入磁盘
                files.transferTo(newFile);
                // 将新图片名称返回到前端
                return resultBase;
            } else {
                return resultBase;
            }
        }catch (Exception e){

        }
        return resultBase;
    }
}
