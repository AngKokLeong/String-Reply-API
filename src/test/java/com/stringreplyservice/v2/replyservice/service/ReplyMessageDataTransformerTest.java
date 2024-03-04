package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMessageDataTransformerTest {
    

    private ReplyMessageDataTransformer replyMessageDataTransformer;

    @Autowired
    public ReplyMessageDataTransformerTest(ReplyMessageDataTransformer replyMessageDataTransformer){
        this.replyMessageDataTransformer = replyMessageDataTransformer;
    }

    @Test
    public void testTransformDataWithRule11() throws Exception {
        String rule = "11";
        String data = "abcabc";

        String result = replyMessageDataTransformer.transformData(rule, data);

        assertTrue(result.equals("abcabc"));
    }

    @Test
    public void testTransformDataWithRule12() throws Exception {
        String rule = "12";
        String data = "abcabc";

        String result = replyMessageDataTransformer.transformData(rule, data);

        assertTrue(result.equals("cfc0845bfbb119d151bcbc4ab13e1387"));
    }

    @Test
    public void testTransformDataWithRule22() throws Exception {
        String rule = "22";
        String data = "abcabc";

        String result = replyMessageDataTransformer.transformData(rule, data);

        assertTrue(result.equals("8d915a0efee2acd4598776bd27de5f13"));
    }

}
