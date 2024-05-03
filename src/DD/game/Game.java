package DD.game;

import DD.board.Board;
import DD.Menu;
import DD.Msg;
import DD.board.BoardType;
import DD.persons.Person;

import java.util.List;

public class Game {

    // Constant
    private int boardSize;

    // Attributes
    private final Menu menu;
    List<Person> players;
    Board board;
    Dice dice;

    // Constructor
    public Game() {
        this.menu = new Menu();
        this.dice = new DiceOne(); // NormalDice();
        this.board = new Board(BoardType.TESTING); // C'est ici qu'on choisit le type de plateau
        // on pourrait le passer en paramètre du constructeur
        this.boardSize =  board.getSquares().size();
    }

    // Method : play
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
            menu.displayTurnNumber(turnCount);
            try {
                //----------------------------------
                gameOver = gameTurn(players, board);
                //----------------------------------
            } catch (PersonOutOfBoard player) {
                System.out.println("Bon, on va dire que " + player.playerName + " a gagné.");
                gameOver = true;
            }
            turnCount++;
        }
        menu.endOfGameMenu();
    }

    // Méthode : jouer un tour
    private boolean gameTurn(List<Person> players, Board board) throws PersonOutOfBoard {

        int diceValue, newPosition;
        boolean gameOver = false;

        // Pour tous les joueurs :
        for (Person player : players) {

            menu.displayPlayerName(player);

            diceValue = dice.throwDice();

            newPosition = player.getPosition() + diceValue;
            player.setPosition(Math.min(newPosition, boardSize));

            // Afficher les infos sur le coup joué
            menu.displayPlayerStatus(player, diceValue, newPosition);

            // Throw exception if new position is out of board
            if (newPosition > boardSize) {
                menu.displayWinner(player);
                throw new PersonOutOfBoard(player);
            }

            // Ouvrir la case à la nouvelle position
            board.getSquare(newPosition).openSquare();

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
