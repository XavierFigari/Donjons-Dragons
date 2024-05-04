package DD.board.squares.enemies;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareSorcerer implements Square {
    @Override
    public String toString() {
        return "sorcier";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getTypeString() + " et j'interagis avec un " + this);
    }
}
