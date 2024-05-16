package DD.board.potions;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquarePotionBig extends Square {

    public SquarePotionBig(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Case grande potion";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Tu as trouvé une GRANDE potion magique ! Tu reprends 2 points de vie !");
        person.setLife(person.getLife() + 5);
        ui.display("Ton niveau de vie est maintenant de " + person.getLife() + " points.\n");
        ui.display(person.toString());
    }
}
