package main.java.dd.board.tools;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.tools.Lightning;

import java.util.List;

public class SquareLightning extends SquareTool {

    public SquareLightning(UserInterface ui, List<Person> allowedPersons) {
        super(ui, allowedPersons);
        this.tool = new Lightning();
    }

    @Override
    public String toString() {
        return "Case éclair";
    }

}
