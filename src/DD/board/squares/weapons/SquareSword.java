package DD.board.squares.weapons;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareSword implements Square {
    @Override
    public String toString() {
        return "épée";
    }

    @Override
    public void interact(Person person) {
        // Epée : augmente l’attaque de 5 points
        person.setForce(person.getForce()+5);
        System.out.println(person.getTypeString() +
                " est tombé sur une " + this + "! Elle lui fait gagner 5 points de force");
    }
}
