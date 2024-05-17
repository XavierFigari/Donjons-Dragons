package DD.game;

import DD.board.Board;
import DD.UserInterface;
import DD.Msg;
import DD.board.BoardType;
import DD.persons.Person;
import DD.persons.PersonIsDeadException;
import DD.persons.Warrior;
import DD.persons.Wizard;

import java.util.ArrayList;
import java.util.Arrays;
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
    }

    // Method : play
    public void play() {
        int turnCount = 1;
        boolean gameOver = false;

        // Greetings !
        ui.printBox("DONJONS ET DRAGONS" );

        // Create players !
        // players = ui.getPlayers();

        players = new ArrayList<>(Arrays.asList(
                new Warrior("Warrior 1"),
//                new Wizard("Wizard 1"),
//                new Wizard("Wizard 2"),
//                new Warrior("Warrior 2"),
//                new Warrior("Warrior 3"),
                new Wizard("Wizard 3")
        ));


        // Create board : pass the players to the board, to set the allowed persons for each square
        this.board = new Board(BoardType.RANDOM, ui, players); // C'est ici qu'on choisit le type de plateau
        this.boardSize =  board.getSquares().size();

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
                ui.display("Bon, on va dire qu'il a gagné.");
                ui.displayWinner(currentPlayer.playerName);
                gameOver = true;
            }
            turnCount++;
        }
        ui.endOfGameMenu();
    }

    // Méthode : jouer un tour
    private boolean gameTurn(List<Person> players, Board board) throws PersonOutOfBoard {

        int diceValue, newPosition;
        boolean outOfBoard = false;
        boolean gameOver = false;

        // Pour tous les joueurs :
        for (int i = 0; i < players.size(); i++) {

//        for (Person player : players) {   // Ne marche pas car on supprime des éléments de la liste dans la boucle

            Person player = players.get(i);

            if (player.getLife() <= 0 || player.getPosition() >= boardSize) {
                continue;
            }

            ui.displayPlayerName(player);
//            ui.askToThrowDice();

            diceValue = dice.throwDice();

            newPosition = Math.min(player.getPosition() + diceValue, boardSize);
            outOfBoard = player.getPosition() + diceValue > boardSize;

            player.setPosition(newPosition);

            // Afficher les infos sur le coup joué
            ui.displayPlayerStatus(player, diceValue, newPosition);

            // Faire interagir le joueur avec le contenu de la case
            try {
                board.getSquare(newPosition).interact(player, ui);
            } catch (PersonIsDeadException e) {
                ui.printBox(e.person.getName() + ", tu es mort ! Tu seras ressuscité à la prochaine partie.");
                players.remove(player);
            }

            // Throw exception if new position is out of board
            if (outOfBoard) {
                throw new PersonOutOfBoard(player);
            } else if (newPosition == boardSize) {
                gameOver = true;
                ui.displayWinner(player.getName());
            }

        }
        if (players.isEmpty()) {
            ui.display("Tous les joueurs sont morts !");
            ui.displayGameOver();
            gameOver = true;
        }
        return gameOver;
    }

    private class PersonOutOfBoard extends Exception {
        public String playerName;
        public PersonOutOfBoard(Person player) {
            playerName = player.getName();
        }
    }

}
