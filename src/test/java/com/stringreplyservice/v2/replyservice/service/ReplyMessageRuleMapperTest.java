package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMessageRuleMapperTest {
    

    private ReplyMessageRuleMapper replyMessageRuleMapper;

    @Autowired
    public ReplyMessageRuleMapperTest(ReplyMessageRuleMapper replyMessageRuleMapper){
        this.replyMessageRuleMapper = replyMessageRuleMapper;
    }


    @Test
    public void testInvokeRuleForReverseStringRule() throws Exception, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        String testRule = "1";
        String testData = "kbzw9ru";

        String result = replyMessageRuleMapper.invokeRule(testRule, testData).toString();

        assertTrue(result.equals("ur9wzbk"));
    }

    @Test
    public void testInvokeRuleForMD5EncodingRule() throws Exception, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        String testRule = "2";
        String testData = "kbzw9ru";

        String result = replyMessageRuleMapper.invokeRule(testRule, testData).toString();

        assertTrue(result.equals("0fafeaae780954464c1b29f765861fad"));
    }

}
