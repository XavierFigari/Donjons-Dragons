package main.java.dd.board.enemies;

import main.java.dd.UserInterface;
import main.java.dd.persons.Goblin;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;

import java.util.List;
import java.util.Random;

public class SquareGoblin extends SquareEnemy {

    public SquareGoblin(UserInterface ui) {
        super(ui);
        List<String> goblinNames = List.of("Zasar", "Tyyrro", "Warryn", "Wiwyrholdalphiax");
        String name = goblinNames.get(new Random().nextInt(goblinNames.size()));
        enemy = new Goblin(name);
    }

    @Override
    public String toString() {
        return "Case Gobelin";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
    }
}
