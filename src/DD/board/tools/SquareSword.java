package DD.board.tools;

import DD.UserInterface;
import DD.persons.Person;
import DD.tools.Sword;

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
