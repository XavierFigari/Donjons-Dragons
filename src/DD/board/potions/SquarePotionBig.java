package DD.board.potions;

import DD.board.Square;

public class SquarePotionBig extends SquarePotion implements Square {
    @Override
    public void openSquare() {
        System.out.println("Grande potion");
    }
}
