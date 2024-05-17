package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Dragon;
import DD.persons.Enemy;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

import java.util.List;
import java.util.Random;

public class SquareDragon extends SquareEnemy {

    public SquareDragon(UserInterface ui) {
        super(ui);
        List<String> dragonNames = List.of("Belzebuth", "Holg", "Karg", "Grumbar");
        String name = dragonNames.get(new Random().nextInt(dragonNames.size()));
        enemy = new Dragon(name);
    }

    @Override
    public String toString() {
        return "Case Dragon";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
    }
}
