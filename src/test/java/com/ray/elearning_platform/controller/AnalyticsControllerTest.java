package com.ray.elearning_platform.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

class AnalyticsControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new AnalyticsController());
    }

    @Test
    void analyticsEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(get("/api/analytics/student/summary")
                .param("studentId", String.valueOf(sampleData.studentId()))
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("quizId", String.valueOf(sampleData.quizId()))));

        assertDefaultSuccess(mockMvc.perform(get("/api/analytics/student/progress")
                .param("studentId", String.valueOf(sampleData.studentId()))
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("quizId", String.valueOf(sampleData.quizId()))));

        assertDefaultSuccess(mockMvc.perform(get("/api/analytics/student/weak-topics")
                .param("studentId", String.valueOf(sampleData.studentId()))
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("quizId", String.valueOf(sampleData.quizId()))));

        assertDefaultSuccess(mockMvc.perform(get("/api/analytics/leaderboard")
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("quizId", String.valueOf(sampleData.quizId()))));

        assertDefaultSuccess(mockMvc.perform(get("/api/analytics/teacher/course-scores")
                .param("teacherId", String.valueOf(sampleData.teacherId()))
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("quizId", String.valueOf(sampleData.quizId()))));
    }
}
