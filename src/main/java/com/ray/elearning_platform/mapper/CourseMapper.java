package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.Course;
import com.ray.elearning_platform.resp.CourseDetailResp;
import com.ray.elearning_platform.resp.CourseListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    // 新增课程
    int insertCourse(Course course);

    // 修改课程
    int updateCourse(Course course);

    // 删除课程
    int deleteCourse(@Param("courseId") Integer courseId);

    // 根据ID查询课程
    Course selectById(@Param("courseId") Integer courseId);

    // 查询课程详情
    CourseDetailResp selectCourseDetail(@Param("courseId") Integer courseId);

    // 查询课程列表
    List<CourseListResp> selectCourseList(@Param("category") String category,
                                          @Param("keyword") String keyword);

    // 学生端查询课程列表，包含是否已加入
    List<CourseListResp> selectCourseListForStudent(@Param("studentId") Integer studentId,
                                                    @Param("category") String category,
                                                    @Param("keyword") String keyword);

    // 查询教师创建的课程
    List<Course> selectByTeacherId(@Param("teacherId") Integer teacherId);
}
