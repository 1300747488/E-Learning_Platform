package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OssUploadResp {

    private String originalFilename; // 原始文件名

    private String fileName; // 处理后的文件名

    private String objectKey; // OSS 对象Key，例如 materials/2026/05/xxx.pdf

    private String fileUrl; // 文件访问地址，可保存到业务表

    private String bucketName; // OSS Bucket 名称

    private String contentType; // 文件MIME类型

    private Long fileSize; // 文件大小，单位字节

    private String bizType; // 上传业务类型：MATERIAL / QUESTION_IMAGE / ANSWER_IMAGE / AVATAR
}
