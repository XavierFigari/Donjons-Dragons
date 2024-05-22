package dd.board;

import dd.UserInterface;
import dd.persons.Person;
import dd.persons.PersonIsDeadException;
import dd.tools.OffensiveTool;

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

