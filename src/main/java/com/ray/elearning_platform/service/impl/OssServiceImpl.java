package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.service.OssService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OssServiceImpl implements OssService {

    /**
     * 上传文件到阿里云 OSS。
     *
     * @param file 上传文件，必填；包含原始文件名、文件大小、MIME类型和文件内容
     * @param bizType 上传业务类型，必填；MATERIAL 表示课程资料，QUESTION_IMAGE 表示题干图片，
     *                ANSWER_IMAGE 表示解答题图片答案，AVATAR 表示用户头像
     * @param uploaderId 上传者账户ID，必填；用于后续记录上传者或做权限校验
     * @return 默认成功响应；后续实现时返回 OssUploadResp
     */
    @Override
    public JsonData upload(MultipartFile file, String bizType, Integer uploaderId) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除 OSS 文件。
     *
     * @param objectKey OSS 对象Key，必填；用于定位 Bucket 中的文件
     * @return 默认成功响应；后续实现时返回删除结果
     */
    @Override
    public JsonData delete(String objectKey) {
        return JsonData.buildSuccess();
    }

    /**
     * 获取 OSS 文件访问地址。
     *
     * @param objectKey OSS 对象Key，必填；用于拼接或生成文件访问地址
     * @return 默认成功响应；后续实现时返回文件 URL
     */
    @Override
    public JsonData getFileUrl(String objectKey) {
        return JsonData.buildSuccess();
    }
}
