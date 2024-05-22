package main.java.dd.board;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;
import main.java.dd.tools.OffensiveTool;

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

