package DD.board;

import DD.UserInterface;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;
import DD.tools.OffensiveTool;

import java.util.List;


public abstract class Square {

    protected OffensiveTool tool;
    protected List<Person> allowedPersons;
    protected final UserInterface ui;

    public Square(UserInterface ui) {
        this.ui = ui;
    }

    public abstract void interact(Person person, UserInterface ui) throws PersonIsDeadException ;

}

