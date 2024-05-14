package DD.board.spells;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareFireball extends Square {

    public SquareFireball(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
        if (person instanceof DD.persons.Wizard) {
            ui.display("Tu as trouvé une boule de feu ! Ta force augmente de 7 points !");
            person.setStrength(person.getStrength() + 7);
            ui.display("Ta force est maintenant de " + person.getStrength() + " points.\n");
            ui.display(person.toString());
        }
        else {
            ui.display("Tu as trouvé une boule de feu, mais tu ne peux pas la prendre ! C'est que pour les magiciens !\n");
        }
    }
}
