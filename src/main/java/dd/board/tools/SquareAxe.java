package dd.board.tools;

import dd.UserInterface;
import dd.persons.Person;
import dd.tools.Axe;

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
