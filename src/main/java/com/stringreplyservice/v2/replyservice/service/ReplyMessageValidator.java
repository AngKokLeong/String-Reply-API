package com.stringreplyservice.v2.replyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;

@Service
public class ReplyMessageValidator {
    

    private ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval;

    @Autowired
    public ReplyMessageValidator(ReplyMessageDataComponentRetrieval replyMessageDataComponentRetrieval) {
        this.replyMessageDataComponentRetrieval = replyMessageDataComponentRetrieval;
    }

    public boolean validateMessageStructure(String replyMessage){
        
        String separator = "-";
        String regex = "[a-z0-9]*";

        int numberOfSeparatorOccurence = validateNumberOfSeparatorOccurence(separator, replyMessage);

        if (numberOfSeparatorOccurence != 1) {
            return false;
        }

        String ruleDataComponent = replyMessageDataComponentRetrieval.retrieveRuleDataComponent(separator, replyMessage);

        if (ruleDataComponent.length() != 2){
            return false;
        }

        if (validateInputString(regex, ruleDataComponent) == false){
            return false;
        }

        String messageDataComponent = replyMessageDataComponentRetrieval.retrieveStringDataComponent(separator, replyMessage);
        
        if (messageDataComponent.length() == 0){
            return false;
        }

        if (validateInputString(regex, messageDataComponent) == false){
            return false;
        }

        return true;
    }

    public boolean validateInputString(String regex, String replyMessage){
        return replyMessage.matches(regex);
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
