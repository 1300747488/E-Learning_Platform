package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    /**
     * 管理员查询用户列表接口。
     *
     * @param role 用户角色，可为空
     * @param keyword 搜索关键词，可为空
     * @return 默认成功响应，后续开发时返回 UserListResp 列表
     */
    @GetMapping("/users")
    public JsonData listUsers(@RequestParam(value = "role", required = false) String role,
                              @RequestParam(value = "keyword", required = false) String keyword) {
        return JsonData.buildSuccess();
    }

    /**
     * 管理员修改账户状态接口。
     *
     * @param accountId 账户ID
     * @param status 目标状态
     * @return 默认成功响应
     */
    @PutMapping("/users/{accountId}/status")
    public JsonData updateUserStatus(@PathVariable("accountId") Integer accountId,
                                     @RequestParam("status") String status) {
        return JsonData.buildSuccess();
    }

    /**
     * 管理员查询课程列表接口。
     *
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 默认成功响应，后续开发时返回 CourseListResp 列表
     */
    @GetMapping("/courses")
    public JsonData listCourses(@RequestParam(value = "category", required = false) String category,
                                @RequestParam(value = "keyword", required = false) String keyword) {
        return JsonData.buildSuccess();
    }
}
