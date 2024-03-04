package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMessageRuleProcessorTest {
    
    private ReplyMessageRuleProcessor replyMessageRuleProcessor;

    @Autowired
    public ReplyMessageRuleProcessorTest(ReplyMessageRuleProcessor replyMessageRuleProcessor){
        this.replyMessageRuleProcessor = replyMessageRuleProcessor;
    }

    @Test
    public void testEncodeStringDataIntoMD5() throws Exception {

        String testMessage = "kbzw9ru";

        String result = replyMessageRuleProcessor.processMD5EncodingRule(testMessage);

        assertTrue(result.equals("0FAFEAAE780954464C1B29F765861FAD"));
    }
    
    @Test
    public void testReverseReplyMessageWithEvenNumberStringLength() throws Exception {
        String testMessage = "abcdef";
        String result = replyMessageRuleProcessor.processReverseStringRule(testMessage);

        assertTrue(result.equals("fedcba"));
    }

    @Test
    public void testReverseReplyMessageWithOddNumberStringLength() throws Exception {
        String testMessage = "abcde";
        String result = replyMessageRuleProcessor.processReverseStringRule(testMessage);

        assertTrue(result.equals("edcba"));
    }

}
