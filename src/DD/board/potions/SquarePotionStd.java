package DD.board.potions;

import DD.board.Square;

public class SquarePotionStd extends SquarePotion implements Square {
    @Override
    public void openSquare() {
        System.out.println("Potion standard");
    }
}
