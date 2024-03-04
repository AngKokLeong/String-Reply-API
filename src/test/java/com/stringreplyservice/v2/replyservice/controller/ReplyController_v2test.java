package com.stringreplyservice.v2.replyservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ReplyController_v2test {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReplyMessageEndpointWithRule11() throws Exception {
        this.mockMvc.perform(get("/v2/reply/11-asdasd")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("asdasd")));
    }

    @Test
    public void testReplyMessageEndpointWithRule12() throws Exception {
        this.mockMvc.perform(get("/v2/reply/12-asdasd")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("c91c03ea6c46a86cbc019be3d71d0a1a")));
    }

    @Test
    public void testReplyMessageEndpointWithRule22() throws Exception {
        this.mockMvc.perform(get("/v2/reply/22-asdasd")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("8ed358a7da3cc760364909d4aaf7321e")));
    }

    @Test
    public void testReplyMessageEndpointWithoutSeparator() throws Exception {
        this.mockMvc.perform(get("/v2/reply/22asdasd")).andDo(print()).andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Invalid input")));
    }

    @Test
    public void testReplyMessageEndpointWithoutRuleData() throws Exception {
        this.mockMvc.perform(get("/v2/reply/-asdasd")).andDo(print()).andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Invalid input")));
    }

    @Test
    public void testReplyMessageEndpointWithoutMessageData() throws Exception {
        this.mockMvc.perform(get("/v2/reply/22-")).andDo(print()).andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Invalid input")));
    }

    @Test
    public void testReplyMessageEndpointWithInvalidRule() throws Exception {
        this.mockMvc.perform(get("/v2/reply/00-asdasd")).andDo(print()).andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Invalid input")));
    }

    @Test
    public void testReplyMessageEndpointWithHexCharacter() throws Exception {
        this.mockMvc.perform(get("/v2/reply/00-as#asd")).andDo(print()).andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Invalid input")));
    }
    
}
