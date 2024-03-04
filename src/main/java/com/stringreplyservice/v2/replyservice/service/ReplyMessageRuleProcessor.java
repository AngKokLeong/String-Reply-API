package com.stringreplyservice.v2.replyservice.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

@Service
public class ReplyMessageRuleProcessor {
    
    protected static String REVERSE_STRING = "1";
    protected static String ENCODE_STRING_VIA_MD5 = "2";

    public ReplyMessageRuleProcessor(){}

    public String processReverseStringRule(String data) throws Exception{
        return reverseReplyMessage(data);
    }

    public String processMD5EncodingRule(String data) throws Exception{
        return encodeStringDataIntoMD5(data);
    }

    private String reverseReplyMessage(String replyMessage) throws Exception{

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
    
    private String encodeStringDataIntoMD5(String data) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        md.update(data.getBytes());

        byte[] digest = md.digest();

        String result = DatatypeConverter.printHexBinary(digest).toLowerCase();

        return result;
    }


    
}
