package DD.board.squares.weapons;

import DD.board.squares.Square;
import DD.persons.Person;

public class SquareHammer implements Square {
    @Override
    public String toString() {
        return "massue";
    }

    @Override
    public void interact(Person person) {
        // Massue : augmente l’attaque de 3 points
        person.setForce(person.getForce()+3);
        System.out.println(person.getTypeString() + " est tombé sur une " + this + "! Elle lui fait gagner 3 points de force");
    }
}
