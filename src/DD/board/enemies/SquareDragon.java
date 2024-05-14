package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareDragon extends Square {

    public SquareDragon(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Dragon";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
        ui.display("Un dragon vous attaque !");
    }
}
