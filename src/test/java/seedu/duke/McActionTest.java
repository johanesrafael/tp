package seedu.duke;


import command.action.McAction;
import constants.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Module Credits Test.
 */
public class McActionTest {

    private String[] testCommand = {"mc", "mc -p", "mc -d", "mc -p -d"};

    @Test
    public void act_moduleCommandsInputs_suitableMcDisplayed() {
        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);

        assertAll("McActionTest", () -> assertTrue(d.testSut(testCommand[0]).contains("619")),
            () -> assertTrue(d.testSut(testCommand[1]).contains("619")),
            () -> assertTrue(d.testSut(testCommand[2]).contains("12")),
            () -> assertTrue(d.testSut(testCommand[2]).contains("12")),
            () -> assertTrue(d.testSut(testCommand[2]).contains("12"))
        );
    }
}