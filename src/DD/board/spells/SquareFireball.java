package DD.board.spells;

import DD.board.Square;
import DD.persons.Person;

public class SquareFireball implements Square {
    @Override
    public String toString() {
        return "Boule de feu";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec un " + this);
    }
}
