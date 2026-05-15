package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.MaterialQueryReq;
import com.ray.elearning_platform.req.MaterialUploadReq;
import com.ray.elearning_platform.resp.MaterialDetailResp;
import com.ray.elearning_platform.resp.MaterialListResp;
import com.ray.elearning_platform.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    /**
     * 保存资料上传记录。
     *
     * @param req 资料上传请求体，必填；包含 courseId、title、materialType、filePath、fileSize 和 uploadedBy
     * @return 默认空资料详情；后续实现时返回 MaterialDetailResp
     */
    @Override
    public MaterialDetailResp upload(MaterialUploadReq req) {
        return null;
    }

    /**
     * 删除资料。
     *
     * @param materialId 资料ID，必填；要删除的资料记录ID
     */
    @Override
    public void delete(Integer materialId) {

    }

    /**
     * 查询资料详情。
     *
     * @param materialId 资料ID，必填；用于查询资料、课程和上传者信息
     * @return 默认空资料详情；后续实现时返回 MaterialDetailResp
     */
    @Override
    public MaterialDetailResp detail(Integer materialId) {
        return null;
    }

    /**
     * 查询资料列表。
     *
     * @param req 资料查询请求体，必填；courseId、materialType、keyword 均可为空
     * @return 默认空列表；后续实现时返回 MaterialListResp 列表
     */
    @Override
    public List<MaterialListResp> list(MaterialQueryReq req) {
        return Collections.emptyList();
    }
}
