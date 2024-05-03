package DD.board.enemies;

import DD.board.Square;

public class SquareGoblin extends SquareEnemy implements Square {
    @Override
    public void openSquare() {
        System.out.println("Gobelin");
    }
}
