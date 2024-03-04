package com.stringreplyservice.v2.replyservice.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stringreplyservice.v2.replyservice.exception.InvalidHashMapKeyIndexException;
import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;



@Service
public class ReplyMessageProcessor {
    
    private ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval;
    private ReplyMessageValidator replyMessageValidator;
    private ReplyMessageDataTransformer replyMessageDataTransformer;

    @Autowired
    public ReplyMessageProcessor(ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval, ReplyMessageValidator replyMessageValidator, ReplyMessageDataTransformer replyMessageDataTransformer){
        this.replyMessageDataComponentRetrieval = replyMessageDataComponentRetrieval;
        this.replyMessageValidator = replyMessageValidator;
        this.replyMessageDataTransformer = replyMessageDataTransformer;
    }

    //process the replymessage by splitting the data into two components
    
    public String processMessage(String replyMessage) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InvalidHashMapKeyIndexException, Exception {

        String separator = "-";

        //1. Validate the replyMessage structure
        if (!replyMessageValidator.validateMessageStructure(replyMessage)){
            throw new InvalidRequestException("Invalid request");
        }

        //2. Retrieve two component of data in the replyMessage
        String rule = replyMessageDataComponentRetrieval.retrieveRuleDataComponent(separator, replyMessage);
        String data = replyMessageDataComponentRetrieval.retrieveStringDataComponent(separator, replyMessage);

        //3. Transform the data according to the rule information
        String result = replyMessageDataTransformer.transformData(rule, data);

        return result;
    }
}
