package DD;

public class Msg {

    public static void red(String msg) {
        System.out.println( Colors.colored(Colors.ANSI_RED, msg));
    }
    public static void green(String msg) {
        System.out.println( Colors.colored(Colors.ANSI_GREEN, msg));
    }
    public static void blue(String msg) {
        System.out.println( Colors.colored(Colors.ANSI_CYAN, msg));
    }
    public static void white(String msg) {
        System.out.println( Colors.colored(Colors.ANSI_WHITE, msg));
    }
    public static void rainbow(String msg) {System.out.println(Colors.rainbow(msg));}

    // =======================
    // Print string inside box
    // =======================

    private static int getMaxLength(String... strings) {
        int len = Integer.MIN_VALUE;
        for (String str : strings) {
            len = Math.max(str.length(), len);
        }
        return len;
    }
    private static String padString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }
    private static String fill(char ch, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
    /**
     * Finally, printBox is determining the length of the longest String.
     * Building a top (and bottom line) then iterating the String(s) performing padding
     * (if needed) on the String(s) and then using formatted output - | str |
     * Usage : printBox(strings);
     *
     * @param strings
     */
    public static void printBox(String... strings) {
        int maxBoxWidth = getMaxLength(strings);
        String line = "+" + fill('-', maxBoxWidth + 6) + "+";
        rainbow(line);
        System.out.printf("│   %s   │%n", padString(" ", maxBoxWidth));
        for (String str : strings) {
            System.out.printf("│   %s   │%n", padString(str, maxBoxWidth));
        }
        System.out.printf("│   %s   │%n", padString(" ", maxBoxWidth));
        rainbow(line);
        System.out.println();
    }

}
