package DD;

import DD.persons.Person;
import DD.persons.PlayerType;
import DD.persons.Warrior;
import DD.persons.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner sc = new Scanner(System.in);

    public void displayGameStart() {
       Msg.printBox("Le jeu démarre !");
    }

    public void displayGameOver() {


        Msg.printRainbow("╔═══════════════════════════════╗");
        Msg.printRainbow("║                               ║");
        Msg.printRainbow("║  ╔═╗╔═╗╔╦╗╔═╗  ╔═╗╦  ╦╔═╗╦═╗  ║");
        Msg.printRainbow("║  ║ ╦╠═╣║║║║╣   ║ ║╚╗╔╝║╣ ╠╦╝  ║");
        Msg.printRainbow("║  ╚═╝╩ ╩╩ ╩╚═╝  ╚═╝ ╚╝ ╚═╝╩╚═  ║");
        Msg.printRainbow("║                               ║");
        Msg.printRainbow("╚═══════════════════════════════╝");

    }

    public void displayTurnNumber(int n) {
        Msg.printBlue(Msg.underlined("\nTOUR DE JEU " + n));
    }

    public void display(String info) {
        Msg.printPureWhite(info);
    }

    public void displayRed(String info) {
        Msg.printRed(info);
    }

    private String dieEmoji(int dieVal) {
        // Die emoji starts at 9856 (1), then 9857 (2), etc.
        return Character.toString(9855 + dieVal);
    }

    public void displayPlayerStatus(Person player, int diceValue, int newPosition) {
        Msg.printYellow("  Dé = " + diceValue + " " + dieEmoji(diceValue));
        Msg.printYellow("  Nouvelle position = " + newPosition);
        System.out.println();
    }

    public void displayPlayerName(Person player) {
        Msg.printGreen("\n" + player.getName() + " est en position " + player.getPosition());
        System.out.println(player);
    }

    private String getPlayerName() {
        String textInput = "";
        System.out.print("- Nom ? ");
        return sc.nextLine();
    }

    private PlayerType getPlayerType() {
        String textInput = "";
        System.out.print("- Guerrier (G) ou Magicien (M) ? ");
        while (!textInput.equals("G") && !textInput.equals("M")) {
            textInput = sc.nextLine();
            if (!textInput.equals("G") && !textInput.equals("M")) {
                System.out.println(Colors.colstr(Colors.ANSI_RED, "Ce choix n'est pas autorisé\n"));
                System.out.print("Entrez G ou M : ");
            }
        }
        return textInput.equals("G") ? PlayerType.WARRIOR : PlayerType.WIZARD;
    }

    private Person getPlayer() {
        System.out.println();
        System.out.println("Création d'un personnage");
        System.out.println("------------------------");
        return getPlayerType() == PlayerType.WARRIOR ? new Warrior(getPlayerName()) : new Wizard(getPlayerName());
    }

    private void deletePlayer(Person player) {

    }

    public void quit() {
        System.out.println("Bye bye...");
        System.exit(0);
    }

    private void displayPlayer(Person player) {
        System.out.println("\n" + player);
    }

    private void displayAllPlayers(List<Person> players) {
        if (players.isEmpty()) {
            Msg.printRed("\nAucun joueur n'a été créé\n");
        } else {
            System.out.println("\nNombre de Joueurs : " + players.size() + "\n");
            for (Person player : players) {
                System.out.println(player);
            }
        }
    }


    public void endOfGameMenu() {
        String answer;
        System.out.println("\n");
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println("        FIN DU JEU       ");
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°");
        do {
            System.out.println("R. Recommencer une partie");
            System.out.println("Q. Quitter le jeu");
            System.out.print("\nEntrez R ou Q : ");
            answer = sc.nextLine();
            switch (answer) {
                case "Q":
                    quit();
                    break;
                case "R":
                    System.out.println("\nOn recommence tout !");
                    break;
                default:
                    Msg.printRed("Ce choix n'est pas autorisé\n");
            }
        } while (!answer.equals("R"));
    }


    private void displayMainMenu() {
        Msg.printBlue(Msg.underlined("MENU PRINCIPAL"));
        System.out.println("│ C. Créer un personnage");
        System.out.println("│ A. Afficher les personnages déjà créés");
        System.out.println("│ M. Modifier le dernier personnage créé");
        System.out.println("│ J. Jouer !");
        System.out.println("│ Q. Quitter le jeu");
        System.out.print("\nEntrez C, A, M, J ou Q : ");
    }

    /**
     * Display a menu to create a list of players, and start the game
     *
     * @return List of <Person>, after the user chooses "J" (Jouer)
     */
    public List<Person> getPlayers() {
        String answer;
        List<Person> players = new ArrayList<Person>();

        do {
            displayMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "C": // Create player
                    // Add player (interactively)
                    players.add(getPlayer());
                    displayPlayer(players.getLast());
                    break;
                case "A": // Display players
                    displayAllPlayers(players);
                    break;
                case "M": // Modify player
                    if (players.isEmpty()) {
                        Msg.printRed("\nVous ne pouvez pas modifier un joueur tant que " +
                                "vous n'en avez pas créé !\n");
                        break;
                    }
                    players.removeLast();
                    players.add(getPlayer());
                    displayPlayer(players.getLast());
                    break;
                case "J": // Start Game
                    if (players.isEmpty()) {
                        // Créer d'abord
                        Msg.printRed("\nVous ne pouvez pas jouer tant que " +
                                "vous n'avez pas créé de joueur !\n");
                        break;
                    }
                    // this is the only way to exit the loop :
                    return players;
                case "Q":
                    quit();
                default:
                    Msg.printRed("Ce choix n'est pas autorisé\n");
            }
        } while (true);

//        return null;
    }

    public void printBox(String text) {
        Msg.printBox(text);
    }

    public void displayWinner(String playerName) {
        System.out.println();
        Msg.printRainbow(playerName + " a gagné !");
        System.out.println();
    }

    public void askToThrowDice() {
        String answer;
        System.out.print("\nAppuie sur Entrée pour jeter le dé, ou Q pour quitter...");
        answer = sc.nextLine();
        if (answer.equals("Q")) {
            quit();
        }
    }
}
