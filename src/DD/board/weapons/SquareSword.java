package DD.board.weapons;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;
import DD.tools.Sword;

public class SquareSword extends Square {

    public SquareSword(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Epée";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        if (person instanceof DD.persons.Warrior) {
            ui.display("");
            ui.display("🗡 Tu as trouvé une épée !");
            if (person.getOffensiveTool().getAttackLevel() > new Sword().getAttackLevel()) {
                ui.display("Tu as déjà une meilleure arme : " + person.getOffensiveTool());
            } else {
                person.setStrength(person.getStrength() + 3);
                ui.display("Ta force augmente de 5 points, elle est maintenant de " + person.getStrength() + " points. \n");
                ui.display(person.toString());
            }
        } else {
            ui.display("🗡 Tu as trouvé une épée, mais tu ne peux pas la prendre ! C'est que pour les guerriers !");
        }
    }
}
