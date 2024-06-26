package main.java.dd.board.potions;

import main.java.dd.UserInterface;
import main.java.dd.board.Square;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;

public class SquarePotionStd extends Square {

    public SquarePotionStd(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Case potion standard";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Tu as trouvé une potion magique ! Tu reprends 2 points de vie !");
        person.setLife(person.getLife() + 2);
        ui.display("Ton niveau de vie est maintenant de " + person.getLife() + " points.\n");
        ui.display(person.toString());

    }
}
