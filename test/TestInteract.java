import DD.Msg;
import DD.UserInterface;
import DD.board.Board;
import DD.board.BoardType;
import DD.board.Square;
import DD.persons.Person;
import DD.persons.Warrior;
import DD.persons.Wizard;

import java.util.List;

import static java.lang.System.exit;

public class TestInteract {

    public static void main(String[] args) {
        testInteract();
    }

    private static void testInteract() {

        UserInterface ui = new UserInterface();
        List<Person> players = List.of(
                new Warrior("Warrior 1"),
                new Wizard("Wizard 1"),
                new Wizard("Wizard 2"),
                new Warrior("Warrior 2"),
                new Warrior("Warrior 3"),
                new Wizard("Wizard 3")
        );

        Board board = new Board(BoardType.RANDOM, ui, players);
        int j=1;
        for (Square square : board.getSquares()) {
            System.out.println(j + " : " + square.toString());
            j++;
        }
//        exit(0);

        for (int i = 1; i < board.getSquares().size(); i++) {
            for (Person player : players) {
                player.setPosition(i);
                try {
                    board.getSquare(player.getPosition()).interact(player, ui);
                } catch (Exception e) {
                    Msg.printRed("Error in interact method");
                }
            }
        }
    }
}
