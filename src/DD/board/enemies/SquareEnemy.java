package DD.board.enemies;

import DD.UserInterface;
import DD.board.Square;
import DD.persons.Dragon;
import DD.persons.Enemy;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareEnemy extends Square {

    protected Enemy enemy;
    public SquareEnemy(UserInterface ui) {
        super(ui);
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Le " + enemy.getTypeString() + " " + enemy.getName() + " t'attaque !");
        ui.displayRed(person.getName() + ", je vais te buter !");
        // This is where everything happens : look at the beauty of this simple statement :
        person.fight(enemy, ui);

        // Now look at the person.fight method, which is common to all persons and enemies.
    }

}
