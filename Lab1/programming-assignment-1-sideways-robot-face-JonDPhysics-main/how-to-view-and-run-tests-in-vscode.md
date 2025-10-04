# How To View and Run Tests in VS Code (Step by Step)

These instructions assume you have already opened this project in VS Code.

## 1. Install the Java tooling once
1. Open the **Extensions** view (left sidebar icon with four squares, or press `Ctrl` + `Shift` + `X` / `Cmd` + `Shift` + `X` on macOS).
2. Search for **Extension Pack for Java** and click **Install**. This bundle brings in the Test Runner for Java and the Maven helper you need. (If you already see the green checkmark that says **Installed**, you can move on.)

## 2. Let VS Code detect the project
1. When the extensions finish installing, VS Code might pop up a message about "Java project detected". Click **Import** if asked.
2. If you do not see a prompt, press `Ctrl` + `Shift` + `P` (`Cmd` + `Shift` + `P` on macOS) to open the Command Palette.
3. Type `Java: Clean the Java language server workspace` and choose it. VS Code will reload the window; this helps it notice all the tests on the first try.

## 3. Open the Testing view
1. Look at the left sidebar for the **Beaker** icon labeled **Testing**. Click it. (If the icon is missing, confirm the Extension Pack is installed and reload the window.)
2. Once the Testing panel opens, wait a few seconds. VS Code will scan `src/test/java` and list every test class such as `Q01StructureTest` or `Q01OutcomeTest`.

## 4. Run an individual test (practice)
1. Hover over a test name (for example, `Q01OutcomeTest`). You should see a **Run** (▶) icon appear.
2. Click the **Run** icon. A new panel titled **Test Results** slides open at the bottom.
3. Watch the progress indicator; when it finishes, you get a green check or a red X next to the test name.
4. If the test fails, click the entry in the results list. VS Code will open the test file and highlight the assertion that failed. The failure message also appears in the results panel.

## 5. Run all tests in the suite
1. In the Testing view (still in the left sidebar), look at the top for a **Run All Tests** button (a green triangle).
2. Click it to execute every test class at once.
3. When the run completes, the summary stays in the **Test Results** panel. You can expand the dropdowns to see which tests passed or failed.

## 6. Re-run quickly after fixing code
1. The **Test Results** panel keeps a log of your last runs. Each entry has a **Rerun** button.
2. Click **Rerun** after you update your Java code to confirm your fixes.

## 7. Using the integrated terminal if needed
1. The Testing panel uses the same commands as `mvn test`. If you want to compare its output to the terminal, open the VS Code integrated terminal (`Ctrl` + `` ` `` / `Cmd` + `` ` `` on macOS).
2. Run `mvn -B test` to see the console version. The new Java extensions will keep the Testing panel in sync with terminal runs.

## 8. Troubleshooting
- **No tests appear**: make sure the project root (the folder containing `pom.xml`) is what you opened in VS Code. Then use the Command Palette step from section 2 to reload the language server.
- **Still missing test icons**: open any test file and look for the “Run | Debug” code lens above a `@Test` method. If it is missing, the Java Test Runner is not active—reinstall the Extension Pack or restart VS Code.
- **Icons show but runs never finish**: check the lower-right status bar for a Java language server warning. Click it to see the details and follow any setup instructions.

Take these steps once, and afterwards the Testing panel behaves just like a little dashboard: you can click tests, watch the pass/fail counter update, and drill into failure details without reading raw Maven logs.
