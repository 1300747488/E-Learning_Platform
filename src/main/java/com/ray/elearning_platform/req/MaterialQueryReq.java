package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialQueryReq {

    private Integer courseId; // 课程ID

    private String materialType; // 资料类型

    private String keyword; // 搜索关键词
}