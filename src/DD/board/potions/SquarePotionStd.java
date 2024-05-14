package DD.board.potions;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquarePotionStd extends Square {

    public SquarePotionStd(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Potion standard";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
        ui.display("Tu as trouvé une potion magique ! Tu reprends 2 points de vie !");
        person.setLife(person.getLife() + 2);
        ui.display("Ton niveau de vie est maintenant de " + person.getLife() + " points.\n");
        ui.display(person.toString());

    }
}
