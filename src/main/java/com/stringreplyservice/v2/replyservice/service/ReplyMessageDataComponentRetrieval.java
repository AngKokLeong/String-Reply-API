package com.stringreplyservice.v2.replyservice.service;

import org.springframework.stereotype.Service;

@Service
public class ReplyMessageDataComponentRetrieval {
   
    
    public String retrieveRuleDataComponent(String separator, String replyMessage){
        int indexOfSeparator = replyMessage.indexOf(separator);

        return replyMessage.substring(0, indexOfSeparator);
    }

    public String retrieveStringDataComponent(String separator, String replyMessage){
        int indexOfSeparator = replyMessage.indexOf(separator);

        return replyMessage.substring(indexOfSeparator + 1, replyMessage.length());
    }

}
