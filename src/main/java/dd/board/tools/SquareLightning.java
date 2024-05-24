package dd.board.tools;

import dd.UserInterface;
import dd.persons.Person;
import dd.tools.Lightning;

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
