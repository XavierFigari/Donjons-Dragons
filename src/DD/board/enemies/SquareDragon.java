package DD.board.enemies;

import DD.board.Square;
import DD.persons.Person;

public class SquareDragon implements Square {
    @Override
    public String toString() {
        return "Dragon";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec un " + this);
    }
}
