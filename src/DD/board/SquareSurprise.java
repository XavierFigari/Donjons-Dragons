package DD.board;

import DD.UserInterface;
import DD.board.potions.SquarePotionBig;
import DD.board.potions.SquarePotionStd;
import DD.board.spells.SquareFireball;
import DD.board.spells.SquareLightning;
import DD.board.weapons.SquareHammer;
import DD.board.weapons.SquareSword;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

public class SquareSurprise extends Square {

    Square square;

    public SquareSurprise(UserInterface ui) {
        super(ui);
    }
    public SquareSurprise(SquareType squareType, UserInterface ui) {
        super(ui);
        switch (squareType) {
            case HAMMER -> {
                this.square = new SquareHammer(ui);
            }
            case SWORD -> {
                this.square = new SquareSword(ui);
            }
            case LIGHTNING -> {
                this.square = new SquareLightning(ui);
            }
            case FIREBALL -> {
                this.square = new SquareFireball(ui);
            }
            case STANDARD_POTION -> {
                this.square = new SquarePotionStd(ui);
            }
            case BIG_POTION -> {
                this.square = new SquarePotionBig(ui);
            }
        }
    }

    @Override
    public String toString() {
        return "Surprise";
    }

    @Override
    public void interact(Person person, UserInterface ui) throws PersonIsDeadException {
        ui.display("Tu as trouvé une caisse surprise ! Voyons-voir ce qu'elle contient...");
        square.interact(person, ui);
    }
}