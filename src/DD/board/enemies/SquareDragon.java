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
    }

    @Override
    public String toString() {
        return "Case Dragon";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        // As the life of the enemy gets back to its initial value after each fight,
        // we can create a new enemy each time
        List<String> dragonNames = List.of("Belzebuth", "Holg", "Karg", "Grumbar");
        Random random = new Random();
        String name = dragonNames.get(random.nextInt(dragonNames.size()));
        enemy = new Dragon(name);
        super.interact(person, ui);
    }
}
