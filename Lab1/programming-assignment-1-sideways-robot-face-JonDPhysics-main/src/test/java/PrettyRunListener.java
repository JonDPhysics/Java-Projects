import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Custom JUnit RunListener that prints a compact summary with check marks and X's.
 */
public class PrettyRunListener extends RunListener {

    private enum Outcome { FAILED, SKIPPED }

    private final Map<Description, Outcome> outcomes = new HashMap<>();

    @Override
    public void testRunStarted(Description description) {
        System.out.println();
        System.out.printf("Running %d checks...%n", description.testCount());
        System.out.println();
    }

    @Override
    public void testFailure(Failure failure) {
        outcomes.put(failure.getDescription(), Outcome.FAILED);
        System.out.printf("✘ %s%n", displayName(failure.getDescription()));
        printMessage(messageFor(failure));
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        outcomes.put(failure.getDescription(), Outcome.SKIPPED);
        System.out.printf("↷ %s%n", displayName(failure.getDescription()));
        printMessage("Assumption failed: " + messageFor(failure));
    }

    @Override
    public void testIgnored(Description description) {
        outcomes.put(description, Outcome.SKIPPED);
        System.out.printf("↷ %s%n", displayName(description));
        printMessage("Test ignored");
    }

    @Override
    public void testFinished(Description description) {
        if (!outcomes.containsKey(description)) {
            System.out.printf("✔ %s%n", displayName(description));
        }
    }

    @Override
    public void testRunFinished(Result result) {
        System.out.println();
        int failures = result.getFailureCount();
        int skipped = result.getIgnoreCount();
        int run = result.getRunCount();
        int passed = run - failures - skipped;
        System.out.printf("Summary: ✔ %d  ✘ %d  ↷ %d  (total %d)%n", passed, failures, skipped, run);
        if (failures > 0) {
            System.out.println("Some checks failed; see messages above.");
        }
        System.out.println();
    }

    private static String displayName(Description description) {
        return description.getDisplayName();
    }

    private static String messageFor(Failure failure) {
        String message = failure.getMessage();
        if (message == null || message.isBlank()) {
            message = failure.getException().toString();
        }
        return message.strip();
    }

    private static void printMessage(String message) {
        if (message == null || message.isBlank()) {
            return;
        }
        String[] lines = message.split("\\R");
        int limit = Math.min(lines.length, 5);
        for (int index = 0; index < limit; index++) {
            System.out.println("    " + lines[index]);
        }
        if (lines.length > limit) {
            System.out.println("    ..." + " (" + (lines.length - limit) + " more line(s))");
        }
    }
}
