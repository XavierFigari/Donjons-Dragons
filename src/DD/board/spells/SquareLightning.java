package DD.board.spells;

import DD.board.Square;

public class SquareLightning implements Square {
    @Override
    public void openSquare() {
        System.out.println("Eclair");
    }
}
