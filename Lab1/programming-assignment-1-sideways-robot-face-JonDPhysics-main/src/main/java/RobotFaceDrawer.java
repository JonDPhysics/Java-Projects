/**
 * CSCD210 Lab 01 starter file.
 *
 * Complete each method so that it prints exactly the ASCII art described in
 * the lab instructions. The provided tests verify spacing and composition, so
 * avoid extra whitespace and rely on helper methods where requested.
 */
public class RobotFaceDrawer {

    public static void drawTriangleUp() {
        System.out.println("     *");
        System.out.println("    / \\");
        System.out.println("   /   \\");
        System.out.println("  /     \\");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }

    public static void drawTriangleDown() {
        System.out.println("\\         /");
        System.out.println(" \\       /");
        System.out.println("  \\     /");
        System.out.println("   \\   /");
        System.out.println("    \\ /");
        System.out.println("     *");
    }

    public static void drawDiamond() {
        System.out.println("     *");
        System.out.println("    / \\");
        System.out.println("   /   \\");
        System.out.println("  /     \\");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("\\         /");
        System.out.println(" \\       /");
        System.out.println("  \\     /");
        System.out.println("   \\   /");
        System.out.println("    \\ /");
        System.out.println("     *");
    }

    public static void drawCheckedLineStartsFilled() {
       System.out.println("# # # # # # # ");
    }

    public static void drawCheckedLineStartsEmpty() {
        System.out.println(" # # # # # # #");
    }

    public static void drawCheckedPattern() {

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                drawCheckedLineStartsFilled();
            }
            else{
                drawCheckedLineStartsEmpty();
            }
        }
       /*
       drawCheckedLineStartsFilled();
       drawCheckedLineStartsEmpty();
       drawCheckedLineStartsFilled();
       drawCheckedLineStartsEmpty();
       drawCheckedLineStartsFilled();
       drawCheckedLineStartsEmpty();
       drawCheckedLineStartsFilled();
       drawCheckedLineStartsEmpty();
       drawCheckedLineStartsFilled();
       */
    }

    public static void main(String[] args) {
        drawTriangleUp();
        drawDiamond();
        drawCheckedPattern();
        drawDiamond();
        drawTriangleDown();
        

    }
}
