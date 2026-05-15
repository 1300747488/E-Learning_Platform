package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.resp.CourseListResp;
import com.ray.elearning_platform.resp.UserListResp;
import com.ray.elearning_platform.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    /**
     * 查询用户列表。
     *
     * @param role 用户角色，可为空；可选值 ADMIN / TEACHER / STUDENT，为空时查询全部角色
     * @param keyword 搜索关键词，可为空；用于匹配用户名、姓名或邮箱
     * @return 默认空列表；后续实现时返回 UserListResp 列表
     */
    @Override
    public List<UserListResp> listUsers(String role, String keyword) {
        return Collections.emptyList();
    }

    /**
     * 修改账户状态。
     *
     * @param accountId 账户ID，必填；要修改状态的用户账户ID
     * @param status 目标状态，必填；可选值 ACTIVE / DISABLED / DELETED
     */
    @Override
    public void updateUserStatus(Integer accountId, String status) {

    }

    /**
     * 管理员查询课程列表。
     *
     * @param category 课程分类，可为空；为空时不按分类筛选
     * @param keyword 搜索关键词，可为空；用于匹配课程标题或描述
     * @return 默认空列表；后续实现时返回 CourseListResp 列表
     */
    @Override
    public List<CourseListResp> listCourses(String category, String keyword) {
        return Collections.emptyList();
    }
}
