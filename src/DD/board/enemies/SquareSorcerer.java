package DD.board.enemies;

import DD.board.Square;

public class SquareSorcerer extends SquareEnemy implements Square {
    @Override
    public void openSquare() {
        System.out.println("Sorcier");
    }
}
