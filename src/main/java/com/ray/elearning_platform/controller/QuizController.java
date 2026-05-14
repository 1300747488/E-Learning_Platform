package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    /**
     * 创建测验接口。
     *
     * @param req 创建测验请求体
     * @return 默认成功响应，后续开发时返回 QuizDetailResp
     */
    @PostMapping
    public JsonData createQuiz(@RequestBody QuizCreateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改测验接口。
     *
     * @param req 修改测验请求体
     * @return 默认成功响应
     */
    @PutMapping
    public JsonData updateQuiz(@RequestBody QuizUpdateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 发布或关闭测验接口。
     *
     * @param req 发布状态请求体
     * @return 默认成功响应
     */
    @PutMapping("/publish")
    public JsonData publish(@RequestBody QuizPublishReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除测验接口。
     *
     * @param quizId 测验ID
     * @return 默认成功响应
     */
    @DeleteMapping("/{quizId}")
    public JsonData deleteQuiz(@PathVariable Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验详情接口。
     *
     * @param quizId 测验ID
     * @return 默认成功响应，后续开发时返回 QuizDetailResp
     */
    @GetMapping("/{quizId}")
    public JsonData detail(@PathVariable Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验列表接口。
     *
     * @param courseId 课程ID，可为空
     * @param status 测验状态，可为空
     * @return 默认成功响应，后续开发时返回 QuizListResp 列表
     */
    @GetMapping
    public JsonData list(@RequestParam(required = false) Integer courseId,
                         @RequestParam(required = false) String status) {
        return JsonData.buildSuccess();
    }
}
