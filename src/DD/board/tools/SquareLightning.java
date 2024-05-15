package DD.board.tools;

import DD.UserInterface;
import DD.persons.Person;
import DD.tools.Lightning;

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
