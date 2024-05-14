package DD.board;

import DD.UserInterface;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareEmpty extends Square {

    public SquareEmpty(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Vide";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
        ui.display("Bummer. T'es sur une case vide. Repose-toi, tu en auras besoin.");
    }
}
