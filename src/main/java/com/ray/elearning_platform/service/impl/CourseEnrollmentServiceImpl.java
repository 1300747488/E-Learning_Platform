package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.entity.CourseEnrollment;
import com.ray.elearning_platform.resp.CourseStudentResp;
import com.ray.elearning_platform.resp.StudentCourseResp;
import com.ray.elearning_platform.service.CourseEnrollmentService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    /**
     * 学生加入课程。
     *
     * @param courseId 课程ID，必填；学生要加入的课程
     * @param studentId 学生ID，必填；必须是 STUDENT 角色账户
     * @return 默认空选课记录；后续实现时返回 CourseEnrollment
     */
    @Override
    public CourseEnrollment joinCourse(Integer courseId, Integer studentId) {
        return null;
    }

    /**
     * 学生退出课程。
     *
     * @param courseId 课程ID，必填；学生要退出的课程
     * @param studentId 学生ID，必填；当前学生账户ID
     */
    @Override
    public void leaveCourse(Integer courseId, Integer studentId) {

    }

    /**
     * 查询课程学生列表。
     *
     * @param courseId 课程ID，必填；用于查询该课程下的学生
     * @param status 选课状态，可为空；可选值 ACTIVE / LEFT，为空时查询全部状态
     * @return 默认空列表；后续实现时返回 CourseStudentResp 列表
     */
    @Override
    public List<CourseStudentResp> listCourseStudents(Integer courseId, String status) {
        return Collections.emptyList();
    }

    /**
     * 查询学生课程列表。
     *
     * @param studentId 学生ID，必填；用于查询该学生加入过的课程
     * @param status 选课状态，可为空；可选值 ACTIVE / LEFT，为空时查询全部状态
     * @return 默认空列表；后续实现时返回 StudentCourseResp 列表
     */
    @Override
    public List<StudentCourseResp> listStudentCourses(Integer studentId, String status) {
        return Collections.emptyList();
    }
}
