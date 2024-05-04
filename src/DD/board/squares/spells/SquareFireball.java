package DD.board.squares.spells;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareFireball implements Square {
    @Override
    public String toString() {
        return "boule de feu";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getTypeString() + " et j'interagis avec une " + this);
    }
}
