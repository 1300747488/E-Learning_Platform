package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.QuestionCreateReq;
import com.ray.elearning_platform.req.QuestionUpdateReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class QuestionControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new QuestionController());
    }

    @Test
    void questionEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(post("/api/questions")
                .contentType(JSON)
                .content(json(new QuestionCreateReq(
                        sampleData.quizId(), "SINGLE_CHOICE", "Controller Test Create Question",
                        "https://example.com/question-create.png", "A", "B", "C", "D",
                        "A", "A", "explanation", 10, "Test Topic"
                )))));

        assertDefaultSuccess(mockMvc.perform(put("/api/questions")
                .contentType(JSON)
                .content(json(new QuestionUpdateReq(
                        sampleData.questionId(), "SINGLE_CHOICE", "Controller Test Update Question",
                        "https://example.com/question-update.png", "A", "B", "C", "D",
                        "A", "A", "updated explanation", 10, "Test Topic"
                )))));

        assertDefaultSuccess(mockMvc.perform(delete("/api/questions/{questionId}", sampleData.questionId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/questions/{questionId}", sampleData.questionId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/questions/teacher-list")
                .param("quizId", String.valueOf(sampleData.quizId()))));
        assertDefaultSuccess(mockMvc.perform(get("/api/questions/student-list")
                .param("quizId", String.valueOf(sampleData.quizId()))
                .param("attemptId", String.valueOf(sampleData.attemptId()))
                .param("showAnswer", "true")));
    }
}
