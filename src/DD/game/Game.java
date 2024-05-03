package DD.game;

import DD.board.Board;
import DD.Menu;
import DD.Msg;
import DD.board.BoardType;
import DD.persons.Person;

import java.util.List;
import java.util.Random;

public class Game {

    private static final int BOARD_SIZE = 64;
    private final Menu menu;
    List<Person> players;
    Board board;
    Dice dice;

    public Game() {
        this.menu = new Menu();
        this.dice = new DiceOne(); // NormalDice();
        this.board = new Board(BoardType.TESTING);
    }

    public void play() {
        int turnCount = 1;
        boolean gameOver = false;

        // Greetings !
        menu.printBox("DONJONS ET DRAGONS" );

        // Create players !
        players = menu.createPlayers();

        // Play !
        menu.displayGameStart();
        while (!gameOver) {
            try {
                gameOver = gameTurn(players, turnCount);
            } catch (PersonOutOfBoard player) {
                System.out.println("Bon, on va dire que " + player.playerName + " a gagné.");
                gameOver = true;
            }
            turnCount++;
        }
        menu.endOfGameMenu();
    }

    private boolean gameTurn(List<Person> players, int turnCount) throws PersonOutOfBoard {
        menu.displayTurnNumber(turnCount);
        int diceValue, newPosition;
        boolean gameOver = false;

        // Pour tous les joueurs :
        for (Person player : players) {

            menu.displayPlayerName(player);

            diceValue = dice.throwDice();

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

}
