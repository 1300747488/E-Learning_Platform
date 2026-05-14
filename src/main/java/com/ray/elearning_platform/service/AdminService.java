package com.ray.elearning_platform.service;

import com.ray.elearning_platform.util.JsonData;

public interface AdminService {

    /**
     * 查询用户列表。
     *
     * @param role 用户角色，可为空
     * @param keyword 搜索关键词，可为空
     * @return 用户列表，元素为 UserListResp
     */
    JsonData listUsers(String role, String keyword);

    /**
     * 修改账户状态。
     *
     * @param accountId 账户ID
     * @param status 目标状态：ACTIVE / DISABLED / DELETED
     * @return 修改结果
     */
    JsonData updateUserStatus(Integer accountId, String status);

    /**
     * 管理员查询课程列表。
     *
     * @param category 课程分类，可为空
     * @param keyword 搜索关键词，可为空
     * @return 课程列表
     */
    JsonData listCourses(String category, String keyword);
}
