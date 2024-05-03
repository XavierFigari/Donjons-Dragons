package DD.board.weapons;

import DD.board.Square;
import DD.persons.Person;

public class SquareSword implements Square {
    @Override
    public String toString() {
        return "Epée";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec un " + this);
    }
}
