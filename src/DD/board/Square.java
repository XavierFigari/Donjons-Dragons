package DD.board;

import DD.UserInterface;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;


public abstract class Square {

    private final UserInterface ui;

    public Square(UserInterface ui) {
        this.ui = ui;
    }

    public abstract void interact(Person person, UserInterface ui) throws PersonIsDeadException ;
}

