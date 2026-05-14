package com.ray.elearning_platform.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class AdminControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new AdminController());
    }

    @Test
    void adminEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(get("/api/admin/users")
                .param("role", "STUDENT")
                .param("keyword", "it_student")));

        assertDefaultSuccess(mockMvc.perform(put("/api/admin/users/{accountId}/status", sampleData.studentId())
                .param("status", "ACTIVE")));

        assertDefaultSuccess(mockMvc.perform(get("/api/admin/courses")
                .param("category", "Test")
                .param("keyword", "Controller")));
    }
}
