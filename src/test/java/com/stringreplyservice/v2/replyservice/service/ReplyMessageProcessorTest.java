package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ReplyMessageProcessorTest {
    

    private ReplyMessageProcessor replyMessageProcessor;

    @Autowired
    public ReplyMessageProcessorTest(ReplyMessageProcessor replyMessageProcessor){
        this.replyMessageProcessor = replyMessageProcessor;
    }


    @Test
    public void testReverseReplyMessageWithEvenNumberStringLength() throws Exception {
        String testMessage = "abcdef";
        String result = replyMessageProcessor.reverseReplyMessage(testMessage);

        assertTrue(result.equals("fedcba"));
    }

    @Test
    public void testReverseReplyMessageWithOddNumberStringLength() throws Exception {
        String testMessage = "abcde";
        String result = replyMessageProcessor.reverseReplyMessage(testMessage);

        assertTrue(result.equals("edcba"));
    }

    @Test
    public void testNumberOfSeparatorOccurence() throws Exception {
        String testMessage = "asdasd-asd-asd-asd";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 3);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithoutAnySeparator() throws Exception {
        String testMessage = "asdasdasdasdasd";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 0);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorWithoutAnyText() throws Exception {
        String testMessage = "-";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningOfTheText() throws Exception {

        String testMessage = "-asdasdasdasd";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheEndOfTheText() throws Exception {

        String testMessage = "asdasdasdasd-";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheEndOfTheTextAndSeparatorInTheMiddleOfTheText() throws Exception {

        String testMessage = "asdasda-sdasd-";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 2);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningOfTheTextAndSeparatorInTheMiddleOfTheText() throws Exception {

        String testMessage = "-asdasda-sdasd";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 2);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningAndTheEndAndTheMiddleOfTheText() throws Exception {

        String testMessage = "-asdasda-sdasd-";
        int result = replyMessageProcessor.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 3);
    }

    @Test
    public void testRetrieveRuleDataComponent() throws Exception {

        String testMessage = "11-asdasd";
        String result = replyMessageProcessor.retrieveRuleDataComponent("-", testMessage);

        assertTrue(result.equals("11"));
    }

    @Test
    public void testRetrieveStringDataComponent() throws Exception {

        String testMessage = "11-asdasd";
        String result = replyMessageProcessor.retrieveStringDataComponent("-", testMessage);

        assertTrue(result.equals("asdasd"));
    }

    @Test
    public void testValidateMessageStructure() throws Exception {

        String testMessage = "11-asdasd";

        boolean result = replyMessageProcessor.validateMessageStructure(testMessage);

        assertTrue(result == true);
    }

    @Test
    public void testValidateMessageStructureWithoutSeparator() throws Exception {

        String testMessage = "11asdasdasd";

        boolean result = replyMessageProcessor.validateMessageStructure(testMessage);

        assertTrue(result == false);
    }
}
