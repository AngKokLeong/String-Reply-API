package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMessageDataComponentRetrievalTest {
    


    private ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval;

    @Autowired
    public ReplyMessageDataComponentRetrievalTest(ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval){
        this.replyMessageDataComponentRetrieval = replyMessageDataComponentRetrieval;
    }

    @Test
    public void testRetrieveRuleDataComponent() throws Exception {

        String testMessage = "11-asdasd";
        String result = replyMessageDataComponentRetrieval.retrieveRuleDataComponent("-", testMessage);

        assertTrue(result.equals("11"));
    }

    @Test
    public void testRetrieveStringDataComponent() throws Exception {

        String testMessage = "11-asdasd";
        String result = replyMessageDataComponentRetrieval.retrieveStringDataComponent("-", testMessage);

        assertTrue(result.equals("asdasd"));
    }


}
