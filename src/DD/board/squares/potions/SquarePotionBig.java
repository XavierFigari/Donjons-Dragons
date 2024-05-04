package DD.board.squares.potions;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquarePotionBig extends SquarePotion implements Square {
    @Override
    public String toString() {
        return "grande potion";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getTypeString() + " et j'interagis avec une " + this);
    }
}
