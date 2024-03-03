package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stringreplyservice.v2.replyservice.service.ReplyMessageProcessor;

@SpringBootTest
public class ReplyMessageProcessorTest {
    

    private ReplyMessageProcessor replyMessageProcessor;

    @Autowired
    public ReplyMessageProcessorTest(ReplyMessageProcessor replyMessageProcessor){
        this.replyMessageProcessor = replyMessageProcessor;
    }


    @Test
    public void testReverseReplyMessageWithEvenNumberStringLength() throws Exception {
        String testMessage = "abcdef";
        String result = replyMessageProcessor.reverseReplyMessage(testMessage);

        assertTrue(result.equals("fedcba"));
    }

    @Test
    public void testReverseReplyMessageWithOddNumberStringLength() throws Exception {
        String testMessage = "abcde";
        String result = replyMessageProcessor.reverseReplyMessage(testMessage);

        assertTrue(result.equals("edcba"));
    }

    @Test
    public void testNumberOfSeparatorOccurence() throws Exception {
        String testMessage = "asdasd-asd-asd-asd";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 3);
    }

}
