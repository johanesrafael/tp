//package command.action;
//
//import constants.Constants;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import seedu.duke.Duke;
//
///**
// * Module Credits Test.
// */
//public class McActionTest {
//
//    private String[] testCommand = {"mc", "mc -p", "mc -d", "mc -p -d"};
//
//    @Test
//    public void act_moduleCommandsInputs_suitableMcDisplayed() {
//        Duke d = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
//
//        assertAll("McActionTest", () -> assertTrue(d.testOutputSut(testCommand[0]).contains("619")),
//            () -> assertTrue(d.testOutputSut(testCommand[1]).contains("619")),
//            () -> assertTrue(d.testOutputSut(testCommand[2]).contains("12")),
//            () -> assertTrue(d.testOutputSut(testCommand[2]).contains("12")),
//            () -> assertTrue(d.testOutputSut(testCommand[2]).contains("12"))
//        );
//    }
//}
