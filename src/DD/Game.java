package DD;

import java.util.List;
import java.util.Random;

public class Game {

    private static final int BOARD_SIZE = 64;
    private final Menu menu;

    public Game(Menu menu) {
        this.menu = menu;
    }

    public void play(List<Person> players) {
        int turnCount=1;

        menu.displayGameStart();
        while (! gameFinished(players)) {
            gameTurn(players, turnCount);
            turnCount++;
        }
    }

    private boolean gameFinished(List<Person> players) {
        if (players == null || players.isEmpty()) { return true; }
        for (Person player : players) {
            if (player.getPosition() > BOARD_SIZE) {
                return true;
            }
        }
        return false;
    }

    private void gameTurn(List<Person> players, int turnCount) {
        menu.displayTurnNumber(turnCount);
        Person player;
        int diceValue;
        // Pour tous les joueurs :
        for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
            player = players.get(playerIndex);
            diceValue = throwDice();
            int newPosition = player.getPosition() + diceValue;
            player.setPosition(newPosition);
            menu.displayPlayerTurn(playerIndex, diceValue, newPosition);
        }
    }

    private int throwDice() {
//        menu.askToThrowDice();
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(6) + 1;
    }
}
