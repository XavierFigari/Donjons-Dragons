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
        int turnCount = 1;
        boolean gameOver = false;
        menu.displayGameStart();
        while (!gameOver) {
            try {
                gameOver = gameTurn(players, turnCount);
            } catch (PersonOutOfBoard e) {
                System.out.println("Bon, on va dire qu'il a gagné.");
                gameOver = true;
            }
            turnCount++;
        }
    }

    private class PersonOutOfBoard extends Exception {
        public String playerName;
        public PersonOutOfBoard(Person player) {
            playerName = player.getName();
            Msg.red("Le personnage " + player.getName() + " est sorti du plateau !");
        }
    }

    private boolean gameTurn(List<Person> players, int turnCount) throws PersonOutOfBoard {
        menu.displayTurnNumber(turnCount);
        int diceValue, newPosition;
        boolean gameOver = false;
        // Pour tous les joueurs :
        for (Person player : players) {

            menu.displayPlayerName(player);
            diceValue = throwDice();
            newPosition = player.getPosition() + diceValue;

            player.setPosition(newPosition > BOARD_SIZE ? BOARD_SIZE : newPosition);
            menu.displayPlayerStatus(player, diceValue, newPosition);

            if (newPosition > BOARD_SIZE) {
                menu.displayWinner(player);
                throw new PersonOutOfBoard(player);
            }

        }
        return gameOver;
    }


    private int throwDice() {
//        menu.askToThrowDice();
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(6) + 1;
    }

}
