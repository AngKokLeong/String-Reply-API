package com.stringreplyservice.v2.replyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyMessageValidator {
    

    private ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval;

    @Autowired
    public ReplyMessageValidator(ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval) {
        this.replyMessageDataComponentRetrieval = replyMessageDataComponentRetrieval;
    }

    public boolean validateMessageStructure(String replyMessage){
        
        String separator = "-";

        int numberOfSeparatorOccurence = validateNumberOfSeparatorOccurence(separator, replyMessage);

        if (numberOfSeparatorOccurence != 1) {
            return false;
        }

        String ruleDataComponent = replyMessageDataComponentRetrieval.retrieveRuleDataComponent(separator, replyMessage);

        if (ruleDataComponent.length() != 2){
            return false;
        }

        return true;
    }


    public int validateNumberOfSeparatorOccurence(String separator, String replyMessage){

        int numberOfOccurence = 0;

        int indexOfSeparator = 0;
        
        while (indexOfSeparator != -1){
            indexOfSeparator = replyMessage.indexOf(separator);

            if (indexOfSeparator != -1) {
                numberOfOccurence++;
            }

            replyMessage = replyMessage.substring(indexOfSeparator + 1, replyMessage.length());
        }

        return numberOfOccurence;
    }
}
