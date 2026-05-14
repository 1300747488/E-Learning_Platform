package com.ray.elearning_platform.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

class OssControllerTest extends ControllerTestSupport {

    private MockMvc mockMvc;
    private SampleData sampleData;

    @BeforeEach
    void setUp() {
        sampleData = useRealDatabaseSampleData();
        mockMvc = mockMvc(new OssController());
    }

    @Test
    void ossEndpointsReturnDefaultSuccessWithSampleData() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file", "controller-test.txt", "text/plain", "test".getBytes()
        );

        assertDefaultSuccess(mockMvc.perform(multipart("/api/oss/upload")
                .file(file)
                .param("bizType", "MATERIAL")
                .param("uploaderId", String.valueOf(sampleData.teacherId()))));

        assertDefaultSuccess(mockMvc.perform(delete("/api/oss/file")
                .param("objectKey", "materials/controller-test.txt")));

        assertDefaultSuccess(mockMvc.perform(get("/api/oss/url")
                .param("objectKey", "materials/controller-test.txt")));
    }
}
