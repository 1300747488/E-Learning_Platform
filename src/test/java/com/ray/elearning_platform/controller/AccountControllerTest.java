package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.AccountChangePasswordReq;
import com.ray.elearning_platform.req.AccountLoginReq;
import com.ray.elearning_platform.req.AccountRegisterReq;
import com.ray.elearning_platform.req.AccountUpdateProfileReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class AccountControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new AccountController());
    }

    @Test
    void accountEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(post("/api/account/register")
                .contentType(JSON)
                .content(json(new AccountRegisterReq(
                        "it_new_student", "123456", "123456", "New Student",
                        "new_student@test.com", "18800000001", null, "STUDENT"
                )))));

        assertDefaultSuccess(mockMvc.perform(post("/api/account/login")
                .contentType(JSON)
                .content(json(new AccountLoginReq("it_student", "123456")))));

        assertDefaultSuccess(mockMvc.perform(get("/api/account/current")
                .header("Authorization", "Bearer test-token")));

        assertDefaultSuccess(mockMvc.perform(put("/api/account/profile")
                .contentType(JSON)
                .content(json(new AccountUpdateProfileReq(
                        sampleData.studentId(), "IT Student", "student@test.com",
                        "18800000002", "https://example.com/avatar.png"
                )))));

        assertDefaultSuccess(mockMvc.perform(put("/api/account/password")
                .contentType(JSON)
                .content(json(new AccountChangePasswordReq(
                        sampleData.studentId(), "123456", "654321", "654321"
                )))));

        assertDefaultSuccess(mockMvc.perform(post("/api/account/logout")
                .header("Authorization", "Bearer test-token")));
    }
}
