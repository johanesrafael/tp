//package command.action;
//
//import constants.Constants;
//import org.junit.jupiter.api.Test;
//import seedu.duke.Duke;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class DetailActionTest {
//    private String[] testCommand = {"detail -mod CS2113","detail -mod ST2334"};
//    Duke duke = new Duke(false, System.out, System.in, Constants.PATH, Constants.FILENAME);
//
//    @Test
//    public void containsModuleTest() {
//        assertTrue(duke.testOutputSut(testCommand[0]).contains("CS2113"));
//    }
//
//    @Test
//    public void doesNotContainModuleTest() {
//        assertEquals(Constants.DETAIL_HEAD + Constants.NOT_FOUND,duke.testOutputSut(testCommand[1]));
//    }
//}
