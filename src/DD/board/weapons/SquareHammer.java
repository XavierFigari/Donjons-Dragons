package DD.board.weapons;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareHammer extends Square {

    public SquareHammer(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Marteau";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        if (person instanceof DD.persons.Warrior) {
            ui.display("Tu as trouvé une massue ! Ta force augmente de 3 points !");
            person.setStrength(person.getStrength() + 3);
            ui.display("Ta force est maintenant de " + person.getStrength() + " points. \n");
            ui.display(person.toString());
        }
        else {
            ui.display("Tu as trouvé une massue, mais tu ne peux pas la prendre ! C'est que pour les guerriers !");
        }
    }
}
