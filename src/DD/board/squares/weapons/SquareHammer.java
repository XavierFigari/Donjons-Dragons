package DD.board.squares.weapons;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareHammer implements Square {
    @Override
    public String toString() {
        return "marteau";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getTypeString() + " et j'interagis avec un " + this);
    }
}
