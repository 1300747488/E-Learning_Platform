package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    private Integer materialId; // 资料ID，主键

    private Integer courseId; // 课程ID，关联 course.course_id

    private String title; // 资料标题

    private String materialType; // 资料类型：PDF / VIDEO / NOTE / PPT / OTHER

    private String filePath; // 文件路径

    private Long fileSize; // 文件大小，单位字节

    private Integer uploadedBy; // 上传者ID，关联 account.account_id

    private LocalDateTime createdAt; // 上传时间
}