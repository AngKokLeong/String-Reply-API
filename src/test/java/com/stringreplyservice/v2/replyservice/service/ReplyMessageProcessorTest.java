package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;


@SpringBootTest
public class ReplyMessageProcessorTest {
    

    private ReplyMessageProcessor replyMessageProcessor;

    @Autowired
    public ReplyMessageProcessorTest(ReplyMessageProcessor replyMessageProcessor){
        this.replyMessageProcessor = replyMessageProcessor;
    }

    @Test
    public void testProcessMessageForInvalidRequestExceptionWithoutRule() throws Exception {
        assertThrows(InvalidRequestException.class, () -> {
            replyMessageProcessor.processMessage("-asdasd");
        });
    }

    @Test
    public void testProcessMessageForInvalidRequestExceptionWithoutMessage() throws Exception {
        assertThrows(InvalidRequestException.class, () -> {
            replyMessageProcessor.processMessage("13-");
        });
    }

    @Test
    public void testProcessMessageForInvalidRequestExceptionWithoutSeparator() throws Exception {
        assertThrows(InvalidRequestException.class, () -> {
            replyMessageProcessor.processMessage("13asdasd");
        });
    }

    @Test
    public void testProcessMessage() throws Exception {
        String replyMessage = "12-asdasd";

        String result = replyMessageProcessor.processMessage(replyMessage);

        assertTrue(result.equals("c91c03ea6c46a86cbc019be3d71d0a1a"));

    }

}
