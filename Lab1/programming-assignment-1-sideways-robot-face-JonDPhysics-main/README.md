[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/_YsySlmk)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=20858849)
# Lab 01 — Sideways Robot Face

Welcome to Lab 01. Your goal is to practice writing small Java methods that collaborate to print ASCII art. The finished program should render the "sideways robot face" shown at the end of this document.

## Objectives
- Reinforce using `System.out.print` / `println` without trailing spaces.
- Structure solutions with reusable helper methods.
- Assemble larger output by composing the helpers.

## Prerequisite self-check
Confirm you can do the following before starting:
- Explain the difference between `System.out.print` and `System.out.println`.
- Describe what a static method is and how to call it from `main`.
- Trace a simple ASCII-art specification and outline the lines you’ll need to print.
If any bullet feels shaky, revisit Lecture 01 notes or the Java review snippet linked in Canvas before diving into code.

## Provided Files
- `RobotFaceDrawer.java`: starter class with empty helper methods and a `main` method.
- Unit tests in `src/test/java` that mirror the old Autolab checks. Do not modify these files.

## Tasks
Implement each method in `RobotFaceDrawer` exactly as specified. All output must match the formatting below, including spacing and blank lines. Avoid printing extra spaces at the end of any line.

1. **`drawTriangleUp()`**
   ```
        *
       / \
      /   \
     /     \
    /       \
   /         \
   ```
2. **`drawTriangleDown()`**
   ```
   \         /
    \       /
     \     /
      \   /
       \ /
        *
   ```
3. **`drawDiamond()`** — produce the diamond by calling `drawTriangleUp()` and `drawTriangleDown()`; do not print directly inside this method.
4. **`drawCheckedLineStartsFilled()`**
   ```
   # # # # # # #
   ```
5. **`drawCheckedLineStartsEmpty()`** — reuse `drawCheckedLineStartsFilled()` to achieve:
   ```
    # # # # # # #
   ```
6. **`drawCheckedPattern()`** — build the 9-line checkerboard by alternating the two line helpers (no direct printing):
   ```
   # # # # # # #
    # # # # # # #
   # # # # # # #
    # # # # # # #
   # # # # # # #
    # # # # # # #
   # # # # # # #
    # # # # # # #
   # # # # # # #
   ```
7. **`main(String[] args)`** — clear any temporary code and draw the full sideways robot face:
```
     *
    / \
   /   \
  /     \
 /       \
/         \
     *
    / \
   /   \
  /     \
 /       \
/         \
\         /
 \       /
  \     /
   \   /
    \ /
     *

# # # # # # #
 # # # # # # #
# # # # # # #
 # # # # # # #
# # # # # # #
 # # # # # # #
# # # # # # #
 # # # # # # #
# # # # # # #

     *
    / \
   /   \
  /     \
 /       \
/         \
\         /
 \       /
  \     /
   \   /
    \ /
     *
\         /
 \       /
  \     /
   \   /
    \ /
     *
   ```
   (Make the console wide so the alignment matches.)

Read 2025F-CSCD210-Lab01-Assignment.pdf for more detailed instructions on how to complete this lab.