package DD.board;

import DD.persons.Person;

public class SquareSurprise implements Square {
    @Override
    public String toString() {
        return "Surprise";
    }

    @Override
    public void interact(Person person) {
        System.out.println("Je suis un " + person.getType() + " et j'interagis avec une " + this);
    }
}
