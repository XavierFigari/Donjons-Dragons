package DD.board.spells;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareLightning extends Square {

    public SquareLightning(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Eclair";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        if (person instanceof DD.persons.Wizard) {
            ui.display("Tu as trouvé un éclair ! Ta force augmente de 2 points !");
            person.setStrength(person.getStrength() + 2);
            ui.display("Ta force est maintenant de " + person.getStrength() + " points.\n");
            ui.display(person.toString());
        }
        else {
            ui.display("Tu as trouvé un éclair, mais tu ne peux pas le prendre ! C'est que pour les magiciens !\n");
        }

    }
}
