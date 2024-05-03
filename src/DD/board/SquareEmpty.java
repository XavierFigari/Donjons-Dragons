package DD.board;

import DD.persons.Person;

public class SquareEmpty implements Square {
    @Override
    public String toString() {
        return "Case vide";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec une " + this);
    }
}
