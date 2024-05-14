package DD.game;

import DD.board.Board;
import DD.UserInterface;
import DD.Msg;
import DD.board.BoardType;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;

import java.util.List;

public class Game {

    // Constant
    private int boardSize;

    // Attributes
    private final UserInterface ui;
    List<Person> players;
    Board board;
    Dice dice;

    // Constructor
    public Game() {
        this.ui = new UserInterface();
        this.dice = new DiceOne(); // NormalDice();
        this.board = new Board(BoardType.NORMAL, ui); // C'est ici qu'on choisit le type de plateau
        this.boardSize =  board.getSquares().size();
    }

    // Method : play
    public void play() {
        int turnCount = 1;
        boolean gameOver = false;

        // Greetings !
        ui.printBox("DONJONS ET DRAGONS" );

        // Create players !
        players = ui.getPlayers();

        // Play !
        ui.displayGameStart();
        ui.display("\nLe plateau comporte " + boardSize + " cases.\n");

        while (!gameOver) {
            ui.displayTurnNumber(turnCount);
            try {
                // Play
                gameOver = gameTurn(players, board);
                //----------------------------------
            } catch (PersonOutOfBoard currentPlayer) {
                ui.display("Le personnage " + currentPlayer.playerName + " est sorti du plateau !");
                ui.display("Bon, on va dire que " + currentPlayer.playerName + " a gagné.");
                gameOver = true;
            }
            turnCount++;
        }
        ui.endOfGameMenu();
    }

    // Méthode : jouer un tour
    private boolean gameTurn(List<Person> players, Board board) throws PersonOutOfBoard {

        int diceValue, newPosition;
        boolean gameOver = false;

        // Pour tous les joueurs :
        for (Person player : players) {

            if (player.getLife() <= 0 || player.getPosition() >= boardSize) {
                continue;
            }

            ui.displayPlayerName(player);
//            ui.askToThrowDice();

            diceValue = dice.throwDice();

            newPosition = Math.min(player.getPosition() + diceValue, boardSize);

            player.setPosition(newPosition);

            // Afficher les infos sur le coup joué
            ui.displayPlayerStatus(player, diceValue, newPosition);

            // Faire interagir le joueur avec le contenu de la case
            try {
                board.getSquare(newPosition).interact(player, ui);
            } catch (PersonIsDeadException e) {
                ui.display("Le personnage " + e.person.getName() + " est mort !");
            }

            // Throw exception if new position is out of board
            if (player.getPosition() + diceValue > boardSize) {
                throw new PersonOutOfBoard(player);
            } else if (newPosition == boardSize) {
                gameOver = true;
                ui.displayWinner(player);
            }

        }
        return gameOver;
    }

    private class PersonOutOfBoard extends Exception {
        public String playerName;
        public PersonOutOfBoard(Person player) {
            ui.displayWinner(player);
            playerName = player.getName();
        }
    }

}
