package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.MaterialUploadReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class MaterialControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new MaterialController());
    }

    @Test
    void materialEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        assertDefaultSuccess(mockMvc.perform(post("/api/materials")
                .contentType(JSON)
                .content(json(new MaterialUploadReq(
                        sampleData.courseId(), "Controller Test Material Upload", "PDF",
                        "https://example.com/upload.pdf", 2048L, sampleData.teacherId()
                )))));

        assertDefaultSuccess(mockMvc.perform(delete("/api/materials/{materialId}", sampleData.materialId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/materials/{materialId}", sampleData.materialId())));
        assertDefaultSuccess(mockMvc.perform(get("/api/materials")
                .param("courseId", String.valueOf(sampleData.courseId()))
                .param("materialType", "PDF")
                .param("keyword", "Controller")));
    }
}
