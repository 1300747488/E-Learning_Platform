package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    /**
     * 开始或继续作答接口。
     *
     * @param quizId 测验ID
     * @param studentId 学生ID
     * @return 默认成功响应，后续开发时返回作答记录和题目列表
     */
    @PostMapping("/start")
    public JsonData startOrContinue(@RequestParam("quizId") Integer quizId,
                                    @RequestParam("studentId") Integer studentId) {
        return JsonData.buildSuccess();
    }

    /**
     * 保存答案接口。
     *
     * @param req 保存答案请求体
     * @return 默认成功响应
     */
    @PostMapping("/save")
    public JsonData saveAnswers(@RequestBody QuizAnswerSaveReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 提交测验接口。
     *
     * @param req 提交测验请求体
     * @return 默认成功响应，后续开发时返回 QuizResultResp
     */
    @PostMapping("/submit")
    public JsonData submit(@RequestBody QuizSubmitReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询测验结果接口。
     *
     * @param attemptId 作答记录ID
     * @return 默认成功响应，后续开发时返回 QuizResultResp
     */
    @GetMapping("/{attemptId}/result")
    public JsonData result(@PathVariable("attemptId") Integer attemptId) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询学生历史作答接口。
     *
     * @param studentId 学生ID
     * @return 默认成功响应，后续开发时返回 QuizHistoryResp 列表
     */
    @GetMapping("/history")
    public JsonData history(@RequestParam("studentId") Integer studentId) {
        return JsonData.buildSuccess();
    }
}
