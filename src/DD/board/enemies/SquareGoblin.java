package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareGoblin extends Square {

    public SquareGoblin(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Gobelin";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Un gobelin vous attaque !");
    }
}
