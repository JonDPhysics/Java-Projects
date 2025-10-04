import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests that the drawCheckedPattern method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q06OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.drawCheckedPattern();
			String receivedOutput = cap.restore();
			String expectedOutput =
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n";
			assertEquals("Output of drawCheckedPattern method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
