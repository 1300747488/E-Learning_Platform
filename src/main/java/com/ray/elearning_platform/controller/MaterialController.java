package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.MaterialQueryReq;
import com.ray.elearning_platform.req.MaterialUploadReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    /**
     * 保存资料上传记录接口。
     *
     * @param req 资料上传请求体
     * @return 默认成功响应，后续开发时返回 MaterialDetailResp
     */
    @PostMapping
    public JsonData upload(@RequestBody MaterialUploadReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除资料接口。
     *
     * @param materialId 资料ID
     * @return 默认成功响应
     */
    @DeleteMapping("/{materialId}")
    public JsonData delete(@PathVariable Integer materialId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询资料详情接口。
     *
     * @param materialId 资料ID
     * @return 默认成功响应，后续开发时返回 MaterialDetailResp
     */
    @GetMapping("/{materialId}")
    public JsonData detail(@PathVariable Integer materialId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询资料列表接口。
     *
     * @param req 资料查询参数
     * @return 默认成功响应，后续开发时返回 MaterialListResp 列表
     */
    @GetMapping
    public JsonData list(@ModelAttribute MaterialQueryReq req) {
        return JsonData.buildSuccess();
    }
}
