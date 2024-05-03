package DD.board.enemies;

import DD.board.Square;

public class SquareDragon extends SquareEnemy implements Square {
    @Override
    public void openSquare() {
        System.out.println("Dragon");
    }
}
