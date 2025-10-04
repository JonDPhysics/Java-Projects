import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests that the drawTriangleUp method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q01OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.drawTriangleUp();
			String receivedOutput = cap.restore();
			String expectedOutput =
				"     *\n" +
				"    / \\\n" +
				"   /   \\\n" +
				"  /     \\\n" +
				" /       \\\n" +
				"/         \\\n";
			String[] receivedLines = receivedOutput.split("\n");
			String[] expectedLines = expectedOutput.split("\n");
			assertEquals("The drawTriangleUp method did not draw the correct number of lines.", expectedLines.length, receivedLines.length);
			int starPos = receivedLines[0].indexOf('*');
			assertTrue("The first output line from drawTriangleUp did not contain a '*' character.", starPos != -1);
			if(starPos > expectedLines[0].indexOf('*')) {
				assertEquals("The first line printed by drawTriangleUp has too many characters before the star.", expectedLines[0].indexOf('*'), starPos);
			}
			if(starPos < expectedLines[0].indexOf('*')) {
				assertEquals("The first line printed by drawTriangleUp does not have enough characters before the star.", expectedLines[0].indexOf('*'), starPos);
			}
			if(receivedLines[0].length() > starPos + 1) {
				fail("The first line printed by drawTriangleUp has some characters after the star.");
			}
			assertEquals("The first line printed by drawTriangleUp did not exactly match specification.", expectedLines[0], receivedLines[0]);
			for(int line = 1; line < expectedLines.length; line++) {
				int printLine = line + 1;
				int slashPos = receivedLines[line].indexOf('/');
				int backPos = receivedLines[line].indexOf('\\');
				assertTrue("Line " + printLine + " printed by drawTriangleUp did not contain a forward slash.", slashPos != -1);
				assertTrue("Line " + printLine + " printed by drawTriangleUp did not contain a backward slash.", backPos != -1);
				assertTrue("On line " + printLine + " printed by drawTriangleUp the backward slash came before the forward slash.", slashPos < backPos);
				if(slashPos < expectedLines[line].indexOf('/')) {
					assertEquals("Line " + printLine + " printed by drawTriangleUp has too many characters before the forward slash.", expectedLines[line].indexOf('/'), slashPos);
				}
				if(slashPos > expectedLines[line].indexOf('/')) {
					assertEquals("Line " + printLine + " printed by drawTriangleUp does not have enough characters before the forward slash.", expectedLines[line].indexOf('/'), slashPos);
				}
				if(backPos < expectedLines[line].indexOf('\\')) {
					assertEquals("Line " + printLine + " printed by drawTriangleUp has too many characters before the backward slash.", expectedLines[line].indexOf('\\'), backPos);
				}
				if(backPos > expectedLines[line].indexOf('\\')) {
					assertEquals("Line " + printLine + " printed by drawTriangleUp does not have enough characters before the backward slash.", expectedLines[line].indexOf('\\'), backPos);
				}
				if(receivedLines[line].length() > backPos + 1) {
					fail("Line " + printLine + " printed by drawTriangleUp has some characters after the backward slash.");
				}
				assertEquals("Line " + printLine + " printed by drawTriangleUp does not exactly match specification.", expectedLines[line], receivedLines[line]);
			}
			assertTrue("The drawTriangleUp method should move to the next line after the last thing it prints.", receivedOutput.charAt(receivedOutput.length() - 1) == '\n');
			assertFalse("The drawTriangleUp method should not print a blank line at the end.", receivedOutput.charAt(receivedOutput.length() - 2) == '\n');
			assertEquals("Output of drawTriangleUp method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
