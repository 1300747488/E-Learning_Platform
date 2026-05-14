package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.AnswerReq;
import com.ray.elearning_platform.req.QuizAnswerSaveReq;
import com.ray.elearning_platform.req.QuizSubmitReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class AttemptControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new AttemptController());
    }

    @Test
    void attemptEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        List<AnswerReq> answers = List.of(new AnswerReq(
                sampleData.questionId(), "A", null, null, "ANSWERED"
        ));

        assertDefaultSuccess(mockMvc.perform(post("/api/attempts/start")
                .param("quizId", String.valueOf(sampleData.quizId()))
                .param("studentId", String.valueOf(sampleData.studentId()))));

        assertDefaultSuccess(mockMvc.perform(post("/api/attempts/save")
                .contentType(JSON)
                .content(json(new QuizAnswerSaveReq(
                        sampleData.attemptId(), sampleData.quizId(), sampleData.studentId(), 30, answers
                )))));

        assertDefaultSuccess(mockMvc.perform(post("/api/attempts/submit")
                .contentType(JSON)
                .content(json(new QuizSubmitReq(
                        sampleData.attemptId(), sampleData.quizId(), sampleData.studentId(), 60, answers
                )))));

        assertDefaultSuccess(mockMvc.perform(get("/api/attempts/{attemptId}/result", sampleData.attemptId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/attempts/history")
                .param("studentId", String.valueOf(sampleData.studentId()))));
    }
}
