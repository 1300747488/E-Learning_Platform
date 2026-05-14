package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/oss")
public class OssController {

    /**
     * 上传文件到阿里云 OSS 接口。
     *
     * @param file 上传文件，必填；请求类型为 multipart/form-data，字段名为 file
     * @param bizType 上传业务类型，必填；MATERIAL / QUESTION_IMAGE / ANSWER_IMAGE / AVATAR
     * @param uploaderId 上传者账户ID，必填；用于记录上传者
     * @return 默认成功响应，后续开发时返回 OssUploadResp
     */
    @PostMapping("/upload")
    public JsonData upload(@RequestParam("file") MultipartFile file,
                           @RequestParam("bizType") String bizType,
                           @RequestParam("uploaderId") Integer uploaderId) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除 OSS 文件接口。
     *
     * @param objectKey OSS 对象Key，必填
     * @return 默认成功响应
     */
    @DeleteMapping("/file")
    public JsonData delete(@RequestParam("objectKey") String objectKey) {
        return JsonData.buildSuccess();
    }

    /**
     * 获取 OSS 文件访问地址接口。
     *
     * @param objectKey OSS 对象Key，必填
     * @return 默认成功响应，后续开发时返回文件访问地址
     */
    @GetMapping("/url")
    public JsonData getFileUrl(@RequestParam("objectKey") String objectKey) {
        return JsonData.buildSuccess();
    }
}
