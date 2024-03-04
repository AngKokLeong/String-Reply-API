package com.stringreplyservice.v2.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyMessageValidatorTest {
    

    private ReplyMessageValidator replyMessageValidator;

    @Autowired
    public ReplyMessageValidatorTest(ReplyMessageValidator replyMessageValidator) {
        this.replyMessageValidator = replyMessageValidator;
    }

    @Test
    public void testNumberOfSeparatorOccurence() throws Exception {
        String testMessage = "asdasd-asd-asd-asd";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 3);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithoutAnySeparator() throws Exception {
        String testMessage = "asdasdasdasdasd";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 0);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorWithoutAnyText() throws Exception {
        String testMessage = "-";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningOfTheText() throws Exception {

        String testMessage = "-asdasdasdasd";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheEndOfTheText() throws Exception {

        String testMessage = "asdasdasdasd-";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 1);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheEndOfTheTextAndSeparatorInTheMiddleOfTheText() throws Exception {

        String testMessage = "asdasda-sdasd-";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 2);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningOfTheTextAndSeparatorInTheMiddleOfTheText() throws Exception {

        String testMessage = "-asdasda-sdasd";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 2);
    }

    @Test
    public void testNumberOfSeparatorOccurenceWithSeparatorAtTheBeginningAndTheEndAndTheMiddleOfTheText() throws Exception {

        String testMessage = "-asdasda-sdasd-";
        int result = replyMessageValidator.validateNumberOfSeparatorOccurence("-", testMessage);

        assertTrue(result == 3);
    }

    @Test
    public void testValidateMessageStructure() throws Exception {

        String testMessage = "11-asdasd";

        boolean result = replyMessageValidator.validateMessageStructure(testMessage);

        assertTrue(result == true);
    }

    @Test
    public void testValidateMessageStructureWithoutSeparator() throws Exception {

        String testMessage = "11asdasdasd";

        boolean result = replyMessageValidator.validateMessageStructure(testMessage);

        assertTrue(result == false);
    }

    @Test
    public void testValidateInputString() throws Exception {
        String regex = "[a-z0-9]*";

        String testMessage = "11asdasd";

        boolean result = replyMessageValidator.validateInputString(regex, testMessage);

        assertTrue(result == true);
    }

    @Test
    public void testValidateInputStringWithSpecialCharacter() throws Exception {
        String regex = "[a-z0-9]*";

        String testMessage = "11*asdasd";

        boolean result = replyMessageValidator.validateInputString(regex, testMessage);

        assertTrue(result == false);
    }

    @Test
    public void testValidateInputStringWithSeparatorAndSpecialCharacterInRuleData() throws Exception {
        String regex = "[a-z0-9]*";

        String testMessage = "1&-asdasd";

        boolean result = replyMessageValidator.validateInputString(regex, testMessage);

        assertTrue(result == false);
    }

    @Test
    public void testValidateInputStringWithSeparatorAndSpecialCharacterInMessageData() throws Exception {
        String regex = "[a-z0-9]*";

        String testMessage = "11-asd$sd";

        boolean result = replyMessageValidator.validateInputString(regex, testMessage);

        assertTrue(result == false);
    }

}
