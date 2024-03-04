package com.stringreplyservice.v2.replyservice.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;

@Service
public class ReplyMessageRuleMapper {
    
    private static Map<String, String> ruleMap;
    static {
        ruleMap = new HashMap<>();
        ruleMap.put("1", "processReverseStringRule");
        ruleMap.put("2", "processMD5EncodingRule");
    }
    
    private ReplyMessageRuleProcessor replyMessageRuleProcessor;

    @Autowired
    public ReplyMessageRuleMapper(ReplyMessageRuleProcessor replyMessageRuleProcessor){
        this.replyMessageRuleProcessor = replyMessageRuleProcessor;    
    }

    public Object invokeRule(String rule, String data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{

        if (ruleMap.get(rule) == null){
            throw new InvalidRequestException("Invalid request");
        }

        Method method = replyMessageRuleProcessor.getClass().getDeclaredMethod(ruleMap.get(rule), String.class);
        method.setAccessible(true);
        return method.invoke(replyMessageRuleProcessor, data);
    }

}
