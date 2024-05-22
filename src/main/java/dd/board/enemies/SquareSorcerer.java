package main.java.dd.board.enemies;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;
import main.java.dd.persons.Sorcerer;

import java.util.List;
import java.util.Random;

public class SquareSorcerer extends SquareEnemy {

    public SquareSorcerer(UserInterface ui) {
        super(ui);
        List<String> sorcererNames = List.of("Shedul", "Saearo", "Ryfel Trythi", "Alevarvain");
        String name = sorcererNames.get(new Random().nextInt(sorcererNames.size()));
        enemy = new Sorcerer(name);
    }

    @Override
    public String toString() {
        return "Case Sorcier";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        super.interact(person, ui);
    }
}
