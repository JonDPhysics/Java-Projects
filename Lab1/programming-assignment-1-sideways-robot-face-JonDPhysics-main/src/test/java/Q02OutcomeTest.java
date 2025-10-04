import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests that the drawTriangleDown method in the RobotFaceDrawer class produce the correct answers.
 * 
 * @author Chad Hogg
 */
public class Q02OutcomeTest {

	@Test
	public void output() {
		OutputCapturer cap = new OutputCapturer();
		try {
			RobotFaceDrawer.drawTriangleDown();
			String receivedOutput = cap.restore();
			String expectedOutput =
				"\\         /\n" +
				" \\       /\n" +
				"  \\     /\n" +
				"   \\   /\n" +
				"    \\ /\n" +
				"     *\n";
			String[] receivedLines = receivedOutput.split("\n");
			String[] expectedLines = expectedOutput.split("\n");
			assertEquals("The drawTriangleDown method did not draw the correct number of lines.", expectedLines.length, receivedLines.length);
			int starPos = receivedLines[receivedLines.length - 1].indexOf('*');
			assertTrue("The last output line from drawTriangleDown did not contain a '*' character.", starPos != -1);
			if(starPos > expectedLines[receivedLines.length - 1].indexOf('*')) {
				assertEquals("The last line printed by drawTriangleDown has too many characters before the star.", expectedLines[receivedLines.length - 1].indexOf('*'), starPos);
			}
			if(starPos < expectedLines[receivedLines.length - 1].indexOf('*')) {
				assertEquals("The last line printed by drawTriangleDown does not have enough characters before the star.", expectedLines[receivedLines.length - 1].indexOf('*'), starPos);
			}
			if(receivedLines[receivedLines.length - 1].length() > starPos + 1) {
				fail("The last line printed by drawTriangleDown has some characters after the star.");
			}
			assertEquals("The last line printed by drawTriangleDown did not exactly match specification.", expectedLines[receivedLines.length - 1], receivedLines[receivedLines.length - 1]);
			for(int line = 0; line < expectedLines.length - 1; line++) {
				int printLine = line + 1;
				int backPos = receivedLines[line].indexOf('\\');
				int slashPos = receivedLines[line].indexOf('/');
				assertTrue("Line " + printLine + " printed by drawTriangleDown did not contain a forward slash.", slashPos != -1);
				assertTrue("Line " + printLine + " printed by drawTriangleDown did not contain a backward slash.", backPos != -1);
				assertTrue("On line " + printLine + " printed by drawTriangleDown the forward slash came before the backward slash.", backPos < slashPos);
				if(slashPos < expectedLines[line].indexOf('/')) {
					assertEquals("Line " + printLine + " printed by drawTriangleDown has too many characters before the forward slash.", expectedLines[line].indexOf('/'), slashPos);
				}
				if(slashPos > expectedLines[line].indexOf('/')) {
					assertEquals("Line " + printLine + " printed by drawTriangleDown does not have enough characters before the forward slash.", expectedLines[line].indexOf('/'), slashPos);
				}
				if(backPos < expectedLines[line].indexOf('\\')) {
					assertEquals("Line " + printLine + " printed by drawTriangleDown has too many characters before the backward slash.", expectedLines[line].indexOf('\\'), backPos);
				}
				if(backPos > expectedLines[line].indexOf('\\')) {
					assertEquals("Line " + printLine + " printed by drawTriangleDown does not have enough characters before the backward slash.", expectedLines[line].indexOf('\\'), backPos);
				}
				if(receivedLines[line].length() > slashPos + 1) {
					fail("Line " + printLine + " printed by drawTriangleDown has some characters after the backward slash.");
				}
				assertEquals("Line " + printLine + " printed by drawTriangleDown does not exactly match specification.", expectedLines[line], receivedLines[line]);
			}
			assertTrue("The drawTriangleDown method should move to the next line after the last thing it prints.", receivedOutput.charAt(receivedOutput.length() - 1) == '\n');
			assertFalse("The drawTriangleDown method should not print a blank line at the end.", receivedOutput.charAt(receivedOutput.length() - 2) == '\n');
			assertEquals("Output of drawTriangleDown method did not exactly match specification.", expectedOutput, receivedOutput);
		}
		finally {
			cap.restore();
		}
	}
	
}
