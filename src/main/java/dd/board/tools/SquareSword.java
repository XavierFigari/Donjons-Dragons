package dd.board.tools;

import dd.UserInterface;
import dd.persons.Person;
import dd.tools.Sword;

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
