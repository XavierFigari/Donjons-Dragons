package main.java.dd.board;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;

public class SquareEmpty extends Square {

    public SquareEmpty(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Case Vide";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Bummer. T'es sur une case vide. Repose-toi, tu en auras besoin.");
    }
}
