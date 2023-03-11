package homework2;

public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void PrintValue(String name, int value) {
        if (value >= 0 && value <= 24) {
            System.out.println(ANSI_BLACK + String.format("%s=%d", name, value) + ANSI_RESET);
        } else if (value > 25 && value <= 50) {
            System.out.println(ANSI_RED + String.format("%s=%d", name, value) + ANSI_RESET);
        } else if (value > 51 && value <= 100) {
            System.out.println(ANSI_GREEN + String.format("%s=%d", name, value) + ANSI_RESET);
        } else {
            System.out.println(String.format("%s=%d", name, value));
        }
    }
    
}
