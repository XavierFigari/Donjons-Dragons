package DD.board;

import DD.UserInterface;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;


public abstract class Square {

    private final UserInterface ui;

    public Square(UserInterface ui) {
        this.ui = ui;
    }

    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        // ui.display("Je suis un " + person.getTypeString() + " et je suis tombé sur une case " + this + "\n");
    }
}

