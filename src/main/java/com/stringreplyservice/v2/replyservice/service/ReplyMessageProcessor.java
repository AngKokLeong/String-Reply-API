package com.stringreplyservice.v2.replyservice.service;

import org.springframework.stereotype.Service;

@Service
public class ReplyMessageProcessor {
   
    //process the replymessage by splitting the data into two components
    
    private String replyMessage;
    private String ruleData;
    private String message;


    
    public String processMessage(String replyMessage) {
        this.replyMessage = replyMessage;
        return "";
    }

    public String validateReplyMessageStructure(String replyMessage){
        return "";
    }


    public int validateNumberOfSeparatorOccurence(String separator, String replyMessage){

        int numberOfOccurence = 0;

        while (replyMessage.length() > 0){
            int indexOfSeparator = replyMessage.indexOf(separator);
            numberOfOccurence++;
            replyMessage = replyMessage.substring(indexOfSeparator + 1, replyMessage.length() - 1);
        }

        return numberOfOccurence;
    }

    public String retrieveRuleDataComponent(String separator, String replyMessage){
        int indexOfSeparator = replyMessage.indexOf(separator);

        return replyMessage.substring(0, indexOfSeparator);
    }

    public String retrieveStringDataComponent(String separator, String replyMessage){
        int indexOfSeparator = replyMessage.indexOf(separator);

        return replyMessage.substring(indexOfSeparator + 1, replyMessage.length());
    }


    public String reverseReplyMessage(String replyMessage){

        int lastCharacterPositionIndex = replyMessage.length() - 1;
        int firstCharacterPositionIndex = 0;

        int totalNumberOfRequiredSwap = (replyMessage.length() % 2 == 0) ? (replyMessage.length() / 2) : (replyMessage.length() / 2) + 1;
        int currentNumberOfSwap = 0;

        char[] characterArray = replyMessage.toCharArray();
        char[] resultArray = new char[replyMessage.length()];

        while (currentNumberOfSwap < totalNumberOfRequiredSwap) {
            resultArray[lastCharacterPositionIndex] = characterArray[firstCharacterPositionIndex];
            resultArray[firstCharacterPositionIndex] = characterArray[lastCharacterPositionIndex];

            firstCharacterPositionIndex++;
            lastCharacterPositionIndex--;
            currentNumberOfSwap++;
        }

        String reverseStringResult = new String(resultArray);

        return reverseStringResult;
    }


    public String retrieveRuleData(String replyMessage) {

        return "";
    }


    private String processRule(){
        return "";
        
    }



    //process Rule 1-1

    //process Rule 1-2

    //what happens if there is wrong input for rules number




}
