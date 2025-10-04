import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests that the main method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q07OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.main(new String[] {});
			String receivedOutput = cap.restore();
			String expectedOutput =
				"     *\n" +
				"    / \\\n" +
				"   /   \\\n" +
				"  /     \\\n" +
				" /       \\\n" +
				"/         \\\n" +
				"     *\n" +
				"    / \\\n" +
				"   /   \\\n" +
				"  /     \\\n" +
				" /       \\\n" +
				"/         \\\n" +
				"\\         /\n" +
				" \\       /\n" +
				"  \\     /\n" +
				"   \\   /\n" +
				"    \\ /\n" +
				"     *\n" +
				"\n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				" # # # # # # # \n" +
				"# # # # # # # \n" +
				"\n" +
				"     *\n" +
				"    / \\\n" +
				"   /   \\\n" +
				"  /     \\\n" +
				" /       \\\n" +
				"/         \\\n" +
				"\\         /\n" +
				" \\       /\n" +
				"  \\     /\n" +
				"   \\   /\n" +
				"    \\ /\n" +
				"     *\n" +
				"\\         /\n" +
				" \\       /\n" +
				"  \\     /\n" +
				"   \\   /\n" +
				"    \\ /\n" +
				"     *\n";
			assertTrue("The main method should move to the next line after the last thing it prints.", receivedOutput.charAt(receivedOutput.length() - 1) == '\n');
			assertFalse("The main method should not print a blank line at the end.", receivedOutput.charAt(receivedOutput.length() - 2) == '\n');
			assertEquals("Output of main method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
