package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareSorcerer extends Square {

    public SquareSorcerer(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Sorcier";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
        ui.display("Un sorcier vous attaque !");
    }
}
