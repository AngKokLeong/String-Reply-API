package com.stringreplyservice.v2.replyservice.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;

@Service
public class ReplyMessageDataTransformer {
    
    //accept the data from ReplyMessage processor
    private ReplyMessageRuleMapper replyMessageRuleMapper;    
    
    @Autowired
    public ReplyMessageDataTransformer(ReplyMessageRuleMapper replyMessageRuleMapper){
        this.replyMessageRuleMapper = replyMessageRuleMapper;
    }


    public String transformData(String rule, String data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NullPointerException{

        if (rule.length() == 0 || data.length() == 0){
            throw new InvalidRequestException("Invalid request");
        }


        String[] ruleArray = rule.split("");

        for(int i=0; i < ruleArray.length; i++){
            data = replyMessageRuleMapper.invokeRule(ruleArray[i], data).toString();
        }
        
        return data;
    }
}
