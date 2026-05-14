package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.CourseEnrollment;
import com.ray.elearning_platform.resp.CourseStudentResp;
import com.ray.elearning_platform.resp.StudentCourseResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseEnrollmentMapper {

    // 新增选课记录
    int insertEnrollment(CourseEnrollment enrollment);

    // 修改选课状态
    int updateStatus(@Param("courseId") Integer courseId,
                     @Param("studentId") Integer studentId,
                     @Param("status") String status);

    // 根据课程ID和学生ID查询选课记录
    CourseEnrollment selectByCourseAndStudent(@Param("courseId") Integer courseId,
                                              @Param("studentId") Integer studentId);

    // 查询课程下的学生列表
    List<CourseStudentResp> selectStudentsByCourseId(@Param("courseId") Integer courseId,
                                                     @Param("status") String status);

    // 查询学生已加入的课程列表
    List<StudentCourseResp> selectCoursesByStudentId(@Param("studentId") Integer studentId,
                                                     @Param("status") String status);

    // 统计课程已加入学生数
    int countActiveStudentsByCourseId(@Param("courseId") Integer courseId);
}
