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
}
