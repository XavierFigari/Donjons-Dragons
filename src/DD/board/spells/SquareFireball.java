package DD.board.spells;

import DD.board.Square;

public class SquareFireball implements Square {
    @Override
    public void openSquare() {
        System.out.println("Boule de feu");
    }
}
