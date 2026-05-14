package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.QuizCreateReq;
import com.ray.elearning_platform.req.QuizPublishReq;
import com.ray.elearning_platform.req.QuizUpdateReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class QuizControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new QuizController());
    }

    @Test
    void quizEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(post("/api/quizzes")
                .contentType(JSON)
                .content(json(new QuizCreateReq(
                        sampleData.courseId(), "Controller Test Quiz Create", "description",
                        60, 100, null, null, sampleData.teacherId()
                )))));

        assertDefaultSuccess(mockMvc.perform(put("/api/quizzes")
                .contentType(JSON)
                .content(json(new QuizUpdateReq(
                        sampleData.quizId(), "Controller Test Quiz Update", "updated",
                        45, 100, null, null, "PUBLISHED"
                )))));

        assertDefaultSuccess(mockMvc.perform(put("/api/quizzes/publish")
                .contentType(JSON)
                .content(json(new QuizPublishReq(sampleData.quizId(), "PUBLISHED")))));

        assertDefaultSuccess(mockMvc.perform(delete("/api/quizzes/{quizId}", sampleData.quizId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/quizzes/{quizId}", sampleData.quizId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/quizzes")
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("status", "PUBLISHED")));
    }
}
