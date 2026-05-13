package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.Material;
import com.ray.elearning_platform.resp.MaterialDetailResp;
import com.ray.elearning_platform.resp.MaterialListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {

    // 新增资料
    int insertMaterial(Material material);

    // 删除资料
    int deleteMaterial(@Param("materialId") Integer materialId);

    // 根据ID查询资料
    Material selectById(@Param("materialId") Integer materialId);

    // 查询资料详情
    MaterialDetailResp selectMaterialDetail(@Param("materialId") Integer materialId);

    // 查询资料列表
    List<MaterialListResp> selectMaterialList(@Param("courseId") Integer courseId,
                                              @Param("materialType") String materialType,
                                              @Param("keyword") String keyword);
}