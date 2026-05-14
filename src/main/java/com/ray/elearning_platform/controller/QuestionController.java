package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.QuestionCreateReq;
import com.ray.elearning_platform.req.QuestionUpdateReq;
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
@RequestMapping("/api/questions")
public class QuestionController {

    /**
     * 创建题目接口。
     *
     * @param req 创建题目请求体
     * @return 默认成功响应，后续开发时返回 QuestionDetailResp
     */
    @PostMapping
    public JsonData createQuestion(@RequestBody QuestionCreateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改题目接口。
     *
     * @param req 修改题目请求体
     * @return 默认成功响应
     */
    @PutMapping
    public JsonData updateQuestion(@RequestBody QuestionUpdateReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 删除题目接口。
     *
     * @param questionId 题目ID
     * @return 默认成功响应
     */
    @DeleteMapping("/{questionId}")
    public JsonData deleteQuestion(@PathVariable Integer questionId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询题目详情接口。
     *
     * @param questionId 题目ID
     * @return 默认成功响应，后续开发时返回 QuestionDetailResp
     */
    @GetMapping("/{questionId}")
    public JsonData detail(@PathVariable Integer questionId) {
        return JsonData.buildSuccess();
    }

    /**
     * 教师端查询题目列表接口。
     *
     * @param quizId 测验ID
     * @return 默认成功响应，后续开发时返回 QuestionListResp 列表
     */
    @GetMapping("/teacher-list")
    public JsonData listForTeacher(@RequestParam Integer quizId) {
        return JsonData.buildSuccess();
    }

    /**
     * 学生端查询题目列表接口。
     *
     * @param quizId 测验ID
     * @param attemptId 作答记录ID
     * @param showAnswer 是否显示正确答案、参考答案和解析
     * @return 默认成功响应，后续开发时返回 StudentQuestionResp 列表
     */
    @GetMapping("/student-list")
    public JsonData listForStudent(@RequestParam Integer quizId,
                                   @RequestParam(required = false) Integer attemptId,
                                   @RequestParam(defaultValue = "false") Boolean showAnswer) {
        return JsonData.buildSuccess();
    }
}
