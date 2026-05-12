package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialUploadReq {

    private Integer courseId; // 课程ID

    private String title; // 资料标题

    private String materialType; // 资料类型：PDF / VIDEO / NOTE / PPT / OTHER

    private String filePath; // 文件路径

    private Long fileSize; // 文件大小，单位字节

    private Integer uploadedBy; // 上传者ID
}