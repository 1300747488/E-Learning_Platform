package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialListResp {

    private Integer materialId; // 资料ID

    private Integer courseId; // 课程ID

    private String courseTitle; // 课程标题

    private String title; // 资料标题

    private String materialType; // 资料类型

    private String filePath; // 文件路径

    private Long fileSize; // 文件大小

    private Integer uploadedBy; // 上传者ID

    private String uploaderName; // 上传者姓名

    private LocalDateTime createdAt; // 上传时间
}