import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputCapturer {

	private ByteArrayOutputStream baos;
	private PrintStream oldOutputStream;
	
	public OutputCapturer() {
		baos = new ByteArrayOutputStream();
		oldOutputStream = System.out;
		System.setOut(new PrintStream(baos));
	}
	
	public String restore() {
		System.out.flush();
		System.setOut(oldOutputStream);
		return baos.toString();
	}
}
