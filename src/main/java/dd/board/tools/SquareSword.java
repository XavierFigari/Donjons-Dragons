package main.java.dd.board.tools;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.tools.Sword;

import java.util.List;

public class SquareSword extends SquareTool {

    public SquareSword(UserInterface ui, List<Person> allowedPersons) {
        super(ui, allowedPersons);
        this.tool = new Sword(); // This is the important stuff in this class !
    }

    @Override
    public String toString() {
        return "Case épée";
    }

}
