package main.java.dd.board.enemies;

import main.java.dd.UserInterface;
import main.java.dd.board.Square;
import main.java.dd.persons.Enemy;
import main.java.dd.persons.Person;
import main.java.dd.persons.PersonIsDeadException;

public class SquareEnemy extends Square {

    protected Enemy enemy;
    public SquareEnemy(UserInterface ui) {
        super(ui);
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {

        if (enemy == null) {
            ui.display("Un combat a eu lieu ici, mais il n'y a plus personne. Tu lèches un peu de sang pour te remonter le moral.");
            return;
        }

        ui.display("Le " + enemy.getTypeString() + " " + enemy.getName() + " t'attaque !");
        ui.displayRed("\"" + person.getName() + ", je vais te buter !\", hurle " + enemy.getName());

        // Fight !
        person.fight(enemy, ui);
    }

    public void removeEnemy() {
        this.enemy = null;
    }

}
