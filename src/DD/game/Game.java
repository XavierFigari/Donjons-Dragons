package DD.game;

import DD.board.Board;
import DD.Menu;
import DD.Msg;
import DD.persons.Person;

import java.util.List;
import java.util.Random;

public class Game {

    private static final int BOARD_SIZE = 64;
    private final Menu menu;
    Board board;

    public Game(Menu menu) {
        this.menu = menu;
//        this.square = new Square();
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

    private boolean gameTurn(List<Person> players, int turnCount) throws PersonOutOfBoard {
        menu.displayTurnNumber(turnCount);
        int diceValue, newPosition;
        boolean gameOver = false;
        // Pour tous les joueurs :
        for (Person player : players) {

            // Afficher le joueur
            // ------------------
            menu.displayPlayerName(player);

            // Lancer le dé
            // ------------
            diceValue = throwDice();

            // Mettre à jour la position
            // -------------------------
            newPosition = player.getPosition() + diceValue;
            player.setPosition(Math.min(newPosition, BOARD_SIZE));

            // Afficher les infos sur le coup joué
            menu.displayPlayerStatus(player, diceValue, newPosition);

            if (newPosition > BOARD_SIZE) {
                menu.displayWinner(player);
                throw new PersonOutOfBoard(player);
            }

        }
        return gameOver;
    }

    private class PersonOutOfBoard extends Exception {
        public String playerName;
        public PersonOutOfBoard(Person player) {
            playerName = player.getName();
            Msg.red("Le personnage " + player.getName() + " est sorti du plateau !");
        }
    }

    private int throwDice() {
//        menu.askToThrowDice();
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(6) + 1;
    }

}
