package main.java.dd.board.tools;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.tools.Axe;

import java.util.List;

public class SquareAxe extends SquareTool {

    public SquareAxe(UserInterface ui, List<Person> allowedPersons) {
        super(ui, allowedPersons);
        this.tool = new Axe();
    }

    @Override
    public String toString() {
        return "Case hache";
    }
}
