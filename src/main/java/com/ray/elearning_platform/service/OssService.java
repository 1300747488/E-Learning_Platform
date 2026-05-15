package com.ray.elearning_platform.service;

import com.ray.elearning_platform.resp.OssUploadResp;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    /**
     * 上传文件到阿里云 OSS。
     *
     * @param file 上传文件，必填；由前端 multipart/form-data 表单字段 file 传入
     * @param bizType 上传业务类型，必填；可选值 MATERIAL / QUESTION_IMAGE / ANSWER_IMAGE / AVATAR
     * @param uploaderId 上传者账户ID，必填；用于记录是谁上传了文件
     * @return 上传结果，包含 objectKey、fileUrl、fileSize 等信息
     */
    OssUploadResp upload(MultipartFile file, String bizType, Integer uploaderId);

    /**
     * 删除 OSS 文件。
     *
     * @param objectKey OSS 对象Key，必填；例如 materials/2026/05/xxx.pdf
     */
    void delete(String objectKey);

    /**
     * 获取 OSS 文件访问地址。
     *
     * @param objectKey OSS 对象Key，必填
     * @return 文件访问地址
     */
    String getFileUrl(String objectKey);
}
