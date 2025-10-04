import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A class that runs all unit tests that compiled.
 * 
 * @author Chad Hogg
 */
public class TestDriver {
	
	public enum Problem {
		Q01_DRAW_TRIANGLE_UP(1, "drawTriangleUp", 1, 1, 10, 10),
		Q02_DRAW_TRIANGLE_DOWN(2, "drawTriangleDown", 1, 1, 10, 10),
		Q03_DRAW_DIAMOND(3, "drawDiamond", 1, 1, 10, 10),
		Q04_DRAW_CHECKED_LINE_STARTS_FILLED(4, "drawCheckedLineStartsFilled", 1, 1, 10, 10),
		Q05_DRAW_CHECKED_LINE_STARTS_EMPTY(5, "drawCheckedLineStartsEmpty", 1, 1, 10, 10),
		Q06_DRAW_CHECKED_PATTERN(6, "drawCheckedPattern", 1, 1, 10, 10),
		Q07_MAIN(7, "main", 1, 1, 20, 20),
		;
		
		private int problemNumber;
		private String problemName;
		private int structureTests;
		private int outcomeTests;
		private int maxScore;
		private int pointsPerFailure;
		private Problem (int problemNumber, String problemName, int structureTests, int outcomeTests, int maxScore, int pointsPerFailure) {
			this.problemNumber = problemNumber;
			this.problemName = problemName;
			this.structureTests = structureTests;
			this.outcomeTests = outcomeTests;
			this.maxScore = maxScore;
			this.pointsPerFailure = pointsPerFailure;
		}
		public int getProblemNumber() {
			return problemNumber;
		}
		public String getProblemName() {
			return problemName;
		}
		public int getStructureTests() {
			return structureTests;
		}
		public int getOutcomeTests() {
			return outcomeTests;
		}
		public int getMaxScore() {
			return maxScore;
		}
		public int getPointsPerFailure() {
			return pointsPerFailure;
		}
	}

	//public static final String DIRECTORY_PREFIX = "src/";
	public static final String DIRECTORY_PREFIX = "";
	public static final String JAVA_FILE_NAME = "RobotFaceDrawer.java";
	
	/** The scores I am granting for each problem. */
	private static SortedMap<Problem, Integer> scores;
	/** Any output explaining why points were not granted, for each problem. */
	private static SortedMap<Problem, String> messages;
	/** A compiler. */
	private static JavaCompiler compiler;
	/** A JUnit runner. */
	private static JUnitCore jUnitCore;
	/** Whether or not all structure tests have passed. */
	private static boolean allStructureOK;
	
	static {
		scores = new TreeMap<>();
		messages = new TreeMap<>();
		for(Problem problem : Problem.values()) {
			scores.put(problem, 0);
			messages.put(problem, "");
		}
		compiler = ToolProvider.getSystemJavaCompiler();
		jUnitCore = new JUnitCore();
	}
	
	/**
	 * Runs all of the tests and generates a report about them.
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		allStructureOK = true;
		for(Problem problem : Problem.values()) {
			if(problem.getStructureTests() > 0 || problem.getOutcomeTests() > 0) {
				runTests(problem);
			}
		}
		produceReport();
	}

	/**
	 * Runs the structure and/or outcome tests for a problem.
	 * 
	 * If the problem has both kinds of tests and the structure tests fail, the outcome tests will not be attempted.
	 * 
	 * @param problem The problem whose tests should be run.
	 */
	private static void runTests(Problem problem) {
		int deductions = 0;
		String message = "";
		ByteArrayOutputStream errBAOS = new ByteArrayOutputStream();
		PrintStream errStream = new PrintStream(errBAOS);
		if(compiler.run(null, null, errStream, DIRECTORY_PREFIX + JAVA_FILE_NAME) == 0) {
			if(problem.getStructureTests() > 0) {
				String structureTestName = String.format("Q%02dStructureTest", problem.getProblemNumber());
				if(compiler.run(null, null, errStream, DIRECTORY_PREFIX + structureTestName + ".java") == 0) {
					try {
						Result result = jUnitCore.run(Class.forName(structureTestName));
						for(Failure failure : result.getFailures()) {
							deductions += problem.getPointsPerFailure();
							message += failure.getDescription() + ": " + failure.getException().toString() + "\n\n";
							allStructureOK = false;
						}
					} catch (ClassNotFoundException exception) {
						deductions = problem.getMaxScore();
						message += "The structure test class could not be found.  Please notify the instructor.\n\n";
						System.out.println(exception.getMessage());
					}
				}
				else {
					errStream.flush();
					message = "Could not compile the structure tests for this problem.  Please notify the instructor.\n\n" + errBAOS.toString();
					deductions = problem.getMaxScore();
				}
			}
			if(problem.getOutcomeTests() > 0 && allStructureOK) {
				String outcomeTestName = String.format("Q%02dOutcomeTest", problem.getProblemNumber());
				if(compiler.run(null, null, errStream, DIRECTORY_PREFIX + outcomeTestName + ".java") == 0) {
					try {
						Result result = jUnitCore.run(Class.forName(outcomeTestName));
						for(Failure failure : result.getFailures()) {
							deductions += problem.getPointsPerFailure();
							message += failure.getDescription() + ": " + failure.getException().toString() + "\n\n";
						}
					} catch (ClassNotFoundException exception) {
						deductions = problem.getMaxScore();
						message += "The outcome test class could not be found.  Please notify the instructor.\n\n";
					}
				}
				else {
					errStream.flush();
					message = "Could not compile the outcome tests for this problem.  Please notify the instructor.\n\n" + errBAOS.toString();
					deductions = problem.getMaxScore();
				}
			}
			else if(problem.getOutcomeTests() > 0){
				deductions += problem.getOutcomeTests() * problem.getPointsPerFailure();
				message += "Could not yet run all of these tests because earlier problems must be fixed first.\n\n";
			}
		}
		else {
			errStream.flush();
			message = "Could not run any tests because your class did not compile.\n\n";
			deductions = problem.getMaxScore();
		}
		int score = Math.max(problem.getMaxScore() - deductions, 0);
		scores.put(problem, score);
		messages.put(problem, message);		
	}
	
	/**
	 * Prints a report of the points and feedback for each AutoLab problem.
	 */
	private static void produceReport() {
		final String HASHTAG_LINE = "######################################################################";
		int totalScore = 0;
		int totalMaxScore = 0;
		for(Problem problem : Problem.values()) {
			System.out.println(HASHTAG_LINE);
			System.out.println("# Problem " + String.format("%02d", problem.getProblemNumber()) + " " + problem.getProblemName() + ": " + scores.get(problem) + "/" + problem.getMaxScore());
			System.out.println();
			System.out.println(messages.get(problem));
			totalScore += scores.get(problem);
			totalMaxScore += problem.getMaxScore();
		}
		System.out.println();
		System.out.println(HASHTAG_LINE);
		System.out.println("# Total autograded points: " + totalScore + "/" + totalMaxScore);
		System.out.println();
		System.out.println();
		System.out.println(getJSON());
	}
	
	/**
	 * Creates the JSON map of problems to scores.
	 * 
	 * @return The JSON map of problems to scores.
	 */
	private static String getJSON() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{ \"scores\" : { ");
		for(Problem problem : Problem.values()) {
			buffer.append("\"").append(String.format("%02d", problem.getProblemNumber())).append(" ").append(problem.getProblemName()).append("\"");
			buffer.append(" : ").append(scores.get(problem)).append(", ");
		}
		buffer.delete(buffer.length() - 2, buffer.length());
		buffer.append(" } }");
		return buffer.toString();
	}
}
