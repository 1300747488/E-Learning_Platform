package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.MaterialQueryReq;
import com.ray.elearning_platform.req.MaterialUploadReq;
import com.ray.elearning_platform.resp.MaterialDetailResp;
import com.ray.elearning_platform.resp.MaterialListResp;

import java.util.List;

public interface MaterialService {

    /**
     * 保存资料上传记录。
     *
     * @param req 资料上传请求体，包含课程ID、标题、类型、文件路径、大小和上传者
     * @return 保存后的资料详情
     */
    MaterialDetailResp upload(MaterialUploadReq req);

    /**
     * 删除资料。
     *
     * @param materialId 资料ID
     */
    void delete(Integer materialId);

    /**
     * 查询资料详情。
     *
     * @param materialId 资料ID
     * @return 资料详情
     */
    MaterialDetailResp detail(Integer materialId);

    /**
     * 查询资料列表。
     *
     * @param req 资料查询请求体
     * @return 资料列表
     */
    List<MaterialListResp> list(MaterialQueryReq req);
}
