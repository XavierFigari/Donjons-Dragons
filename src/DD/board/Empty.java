package DD.board;

public class Empty implements Square {
    @Override
    public void openSquare() {
        System.out.println("--vide--");
    }
}
