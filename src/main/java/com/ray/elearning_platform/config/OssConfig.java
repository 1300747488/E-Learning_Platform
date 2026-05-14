package com.ray.elearning_platform.config;

import lombok.Data;

@Data
public class OssConfig {

    private String endpoint; // OSS 访问域名，例如 oss-cn-hangzhou.aliyuncs.com

    private String accessKeyId; // OSS AccessKey ID

    private String accessKeySecret; // OSS AccessKey Secret

    private String bucketName; // OSS Bucket 名称

    private String publicUrlPrefix; // 文件访问地址前缀，例如 https://bucket.oss-cn-hangzhou.aliyuncs.com

    private String materialDir; // 课程资料目录，例如 materials/

    private String questionImageDir; // 题干图片目录，例如 questions/

    private String answerImageDir; // 解答题图片答案目录，例如 answers/

    private String avatarDir; // 用户头像目录，例如 avatars/
}
