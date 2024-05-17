package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Dragon;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;
import DD.persons.Sorcerer;

import java.util.List;
import java.util.Random;

public class SquareSorcerer extends SquareEnemy {

    public SquareSorcerer(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Case Sorcier";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        List<String> sorcererNames = List.of("Shedul", "Saearo", "Ryfel Trythi", "Alevarvain");
        Random random = new Random();
        String name = sorcererNames.get(random.nextInt(sorcererNames.size()));
        enemy = new Sorcerer(name);
        super.interact(person, ui);
    }
}
