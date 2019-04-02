package com.yingsu.newbuss.service;

import javax.servlet.http.HttpSession;

public interface IFileUploadService {
    // 图片上传
    String uploadPictrue(HttpSession session, String pictrueUrl);
}
