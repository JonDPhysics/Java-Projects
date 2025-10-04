import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests that the drawDiamond method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q03OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.drawDiamond();
			String receivedOutput = cap.restore();
			String expectedOutput =
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
				"     *\n";
			String[] receivedLines = receivedOutput.split("\n");
			String[] expectedLines = expectedOutput.split("\n");
			assertEquals("The drawDiamond method did not draw the correct number of lines.", expectedLines.length, receivedLines.length);
			for(int line = 0; line < expectedLines.length; line++) {
				int printLine = line + 1;
				assertEquals("Line " + printLine + " printed by drawDiamond does not exactly match specification.", expectedLines[line], receivedLines[line]);
			}
			assertTrue("The drawDiamond method should move to the next line after the last thing it prints.", receivedOutput.charAt(receivedOutput.length() - 1) == '\n');
			assertFalse("The drawDiamond method should not print a blank line at the end.", receivedOutput.charAt(receivedOutput.length() - 2) == '\n');
			assertEquals("Output of drawDiamond method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
