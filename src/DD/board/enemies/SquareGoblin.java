package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Dragon;
import DD.persons.Goblin;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

import java.util.List;
import java.util.Random;

public class SquareGoblin extends SquareEnemy {

    public SquareGoblin(UserInterface ui) {
        super(ui);
    }

    @Override
    public String toString() {
        return "Case Gobelin";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        List<String> goblinNames = List.of("Zasar", "Tyyrro", "Warryn Beren", "Wiwyrholdalphiax Perra");
        Random random = new Random();
        String name = goblinNames.get(random.nextInt(goblinNames.size()));
        enemy = new Goblin(name);
        super.interact(person, ui);
    }
}
