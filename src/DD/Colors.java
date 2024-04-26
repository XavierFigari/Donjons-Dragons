package DD;

public class Colors {
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_BLACK = "\u001B[30m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_BLUE = "\u001B[34m";
    public static String ANSI_PURPLE = "\u001B[35m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_WHITE = "\u001B[37m";

    public static String randomColor() {
        String[] colors = {ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE};
        return colors[(int) (Math.random() * colors.length)];
    }
    public static String colored(String color, String text) {
        return color + text + Colors.ANSI_RESET;
    }

}