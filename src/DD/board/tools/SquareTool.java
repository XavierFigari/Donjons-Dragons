package DD.board.tools;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

import java.util.List;

public class SquareTool extends Square {

    public SquareTool(UserInterface ui, List<Person> allowedPersons) {
        super(ui);
        this.allowedPersons = allowedPersons;
    }

    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Hello, " + person.getName() + " !");
        ui.display("Tu as trouvé " + tool);
        if (allowedPersons.contains(person)) {
            ui.display(person.pickTool(tool));
        } else {
            ui.display("Tu n'as pas le droit de prendre cet objet.");
        }
    }

}
