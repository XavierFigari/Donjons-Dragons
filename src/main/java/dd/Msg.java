package main.java.dd;

import java.util.Objects;

public class Msg {

    public static void printRed(String msg) {System.out.println( Colors.colstr(Colors.ANSI_RED, msg)); }
    public static void printGreen(String msg) {
        System.out.println( Colors.colstr(Colors.ANSI_GREEN, msg));
    }
    public static void printYellow(String msg) { System.out.println( Colors.colstr(Colors.ANSI_YELLOW, msg));}
    public static void printBlue(String msg) { System.out.println( Colors.colstr(Colors.ANSI_CYAN, msg)); }
    public static void printWhite(String msg) {
        System.out.println( Colors.colstr(Colors.ANSI_WHITE, msg));
    }
    public static void printPureWhite(String info) {
        System.out.println(Colors.colstr(Colors.PURE_WHITE, info));
    }
    public static void printRainbow(String msg) {System.out.println(Colors.rainbow(msg));}

    public static String underlined(String msg) {return "\u001b[4m" + msg + "\u001b[0m";}
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
        return str + fill(' ', len - str.length());
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
    public static void printBox(String color, String... strings) {
        int maxBoxWidth = getMaxLength(strings);
        String line = "+" + fill('-', maxBoxWidth + 6) + "+";
        if (Objects.equals(color, Colors.RAINBOW)) {
            printRainbow(line);
        } else {
            System.out.println(Colors.colstr(color, line));
        }
        System.out.printf("│   %s   │%n", padString(" ", maxBoxWidth));
        for (String str : strings) {
            System.out.printf("│   %s   │%n", Colors.colstr(color.equals(Colors.RAINBOW)?Colors.ANSI_PURPLE:color, padString(str, maxBoxWidth)));
        }
        System.out.printf("│   %s   │%n", padString(" ", maxBoxWidth));
        if (Objects.equals(color, Colors.RAINBOW)) {
            printRainbow(line);
        } else {
            System.out.println(Colors.colstr(color, line));
        }
        System.out.println();
    }
}
