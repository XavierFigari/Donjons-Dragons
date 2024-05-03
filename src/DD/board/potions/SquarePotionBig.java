package DD.board.potions;

import DD.board.Square;
import DD.persons.Person;

public class SquarePotionBig extends SquarePotion implements Square {
    @Override
    public String toString() {
        return "Potion Big";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec un " + this);
    }
}
