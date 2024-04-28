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

    public static String[] rainbowColors =
            {ANSI_PURPLE, ANSI_BLUE, ANSI_CYAN, ANSI_GREEN, ANSI_YELLOW, ANSI_RED};


    public static String colored(String color, String text) {
        return color + text + Colors.ANSI_RESET;
    }

    public static String rainbow(String text) {
        String s="";
        for (int i = 0; i < text.length(); i++) {
            String color = Colors.rainbowColors[i % Colors.rainbowColors.length];
            s+=color + text.charAt(i);
        }
        return s + Colors.ANSI_RESET;
    }

}