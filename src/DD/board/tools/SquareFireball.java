package DD.board.tools;

import DD.UserInterface;
import DD.persons.Person;
import DD.tools.Fireball;

import java.util.List;

public class SquareFireball extends SquareTool {

    public SquareFireball(UserInterface ui, List<Person> allowedPersons) {
        super(ui, allowedPersons);
        this.tool = new Fireball();
    }

    @Override
    public String toString() {
        return "Case boule de feu";
    }

}