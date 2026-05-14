package com.ray.elearning_platform.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PageControllerTest extends ControllerTestSupport {

    @Test
    void homeRoutesForwardToIndexJsp() throws Exception {
        MockMvc mockMvc = mockMvc(new PageController());

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.jsp"));

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.jsp"));

        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.jsp"));
    }
}
