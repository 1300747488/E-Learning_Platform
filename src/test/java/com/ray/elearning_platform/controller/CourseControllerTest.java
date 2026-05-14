package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.CourseCreateReq;
import com.ray.elearning_platform.req.CourseUpdateReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class CourseControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new CourseController());
    }

    @Test
    void courseEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(post("/api/courses")
                .contentType(JSON)
                .content(json(new CourseCreateReq(
                        "Controller Test Course Create", "description", "Test", sampleData.teacherId()
                )))));

        assertDefaultSuccess(mockMvc.perform(put("/api/courses")
                .contentType(JSON)
                .content(json(new CourseUpdateReq(
                        sampleData.courseId(), "Updated Course", "updated", "Test", "ACTIVE"
                )))));

        assertDefaultSuccess(mockMvc.perform(delete("/api/courses/{courseId}", sampleData.courseId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses/{courseId}", sampleData.courseId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses").param("category", "Test").param("keyword", "Controller")));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses/student-list")
                .param("studentId", String.valueOf(sampleData.studentId()))
                .param("category", "Test")
                .param("keyword", "Controller")));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses/teacher/{teacherId}", sampleData.teacherId())));
        assertDefaultSuccess(mockMvc.perform(post("/api/courses/{courseId}/students/{studentId}/join",
                sampleData.courseId(), sampleData.studentId())));
        assertDefaultSuccess(mockMvc.perform(post("/api/courses/{courseId}/students/{studentId}/leave",
                sampleData.courseId(), sampleData.studentId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses/{courseId}/students", sampleData.courseId())
                .param("status", "ACTIVE")));
        assertDefaultSuccess(mockMvc.perform(get("/api/courses/by-student/{studentId}", sampleData.studentId())
                .param("status", "ACTIVE")));
    }
}
