import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests that the drawCheckedLineStartsFilled method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q04OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.drawCheckedLineStartsFilled();
			String receivedOutput = cap.restore();
			String expectedOutput = "# # # # # # # \n";
			assertTrue("The drawCheckedLineStartsFilled method did not print enough characters.", receivedOutput.length() >= 13);
			assertTrue("The drawCheckedlineStartsFilled method should start by printing a pound sign.", receivedOutput.charAt(0) == '#');
			assertTrue("The drawCheckedLineStartsFilled method should move to the next line after the last thing it prints.", receivedOutput.charAt(receivedOutput.length() - 1) == '\n');
			assertTrue("The drawCheckedLineStartsFilled method should include a space at the end of its output.", receivedOutput.charAt(receivedOutput.length() - 2) == ' ');
			assertEquals("Output of drawCheckedLineStartsFilled method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
