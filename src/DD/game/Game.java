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
        this.board = new Board(BoardType.IT5,  this.menu); // C'est ici qu'on choisit le type de plateau
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
                // Play
                gameOver = gameTurn(players, board);
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
        String userMsg;
        boolean gameOver = false;
        boolean outOfBoard = false;

        // Pour tous les joueurs :
        for (Person player : players) {

            menu.displayPlayerName(player);

            diceValue = dice.throwDice();

            outOfBoard = (player.getPosition() + diceValue) > boardSize;
            newPosition = Math.min(player.getPosition() + diceValue, boardSize);

            player.setPosition(newPosition);

            // Afficher les infos sur le coup joué
            menu.displayPlayerStatus(player, diceValue, newPosition);

            // Faire interagir le joueur avec le contenu de la case
            board.getSquare(newPosition).interact(player);

            // Throw exception if new position is out of board
            if (outOfBoard) {
                menu.displayWinner(player);
                throw new PersonOutOfBoard(player);
            } else if (newPosition == boardSize) {
                gameOver = true;
                menu.displayWinner(player);
            }

        }
        return gameOver;
    }

    private class PersonOutOfBoard extends Exception {
        public String playerName;
        public PersonOutOfBoard(Person player) {
            playerName = player.getName();
            Msg.printRed("Le personnage " + player.getName() + " est sorti du plateau !");
        }
    }

}
