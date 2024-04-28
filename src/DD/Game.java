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
        while (! gameTurn(players, turnCount)) {
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

    private boolean gameTurn(List<Person> players, int turnCount) {
        menu.displayTurnNumber(turnCount);
        Person player;
        int diceValue;
        boolean gameOver = false;
        // Pour tous les joueurs :
        for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
            player = players.get(playerIndex);
            menu.displayPlayerName(player);
            diceValue = throwDice();
            int newPosition = Math.min(player.getPosition() + diceValue, BOARD_SIZE);
            player.setPosition(newPosition);
            menu.displayPlayerStatus(player, diceValue, newPosition);
            if (newPosition == BOARD_SIZE) {
                menu.displayWinner(player);
                gameOver=true;}
        }
        return gameOver;
    }

    private int throwDice() {
        menu.askToThrowDice();
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(6) + 1;
    }

}
