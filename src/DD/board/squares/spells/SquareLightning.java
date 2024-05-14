package DD.board.squares.spells;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareLightning implements Square {
    @Override
    public String toString() {
        return "éclair";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getTypeString() + " et j'interagis avec un " + this);
    }
}
