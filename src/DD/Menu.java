package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    public void displayGameStart() {
        System.out.println("\n########################################\n");
        System.out.println("               Le jeu démarre !");
        System.out.println("\n########################################\n");
    }

    public void displayTurnNumber(int n) {
        Msg.blue("****** TOUR DE JEU " + n + " ******\n");
    }

    private String dieEmoji(int dieVal) {
        // Die emoji starts at 9856 (1), then 9857 (2), etc.
        return Character.toString(9855 + dieVal);
    }

    public void displayPlayerStatus(Person player, int diceValue, int newPosition) {
        Msg.white("  Dé = " + diceValue + " " + dieEmoji(diceValue));
        Msg.white("  Nouvelle position = " + newPosition);
        System.out.println();
    }

    public void displayPlayerName(Person player) {
        Msg.green("Joueur " + player.getName() + " (" + player.getTypeString() + ") : position " + player.getPosition());
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
                System.out.println(Colors.colored(Colors.ANSI_RED, "Ce choix n'est pas autorisé\n"));
                System.out.print("Entrez G ou M : ");
            }
        }
        ;
        return textInput.equals("G") ? PlayerType.WARRIOR : PlayerType.WIZARD;
    }

    private Person createPlayer() {
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
            Msg.red("\nAucun joueur n'a été créé");
        } else {
            System.out.println("\nNombre de Joueurs : " + players.size() + "\n");
            for (Person player : players) {
                System.out.println(player);
            }
        }
    }

    private void displayPlayerMenu() {
        System.out.println(" ");
        System.out.println("   Que voulez-vous faire maintenant ?\n");
        System.out.println("   │ A. Afficher les personnages déjà créés");
        System.out.println("   │ M. Modifier le personnage qui vient d'être créé (le dernier)");
        System.out.println("   │ C. Créer un autre personnage");
        System.out.println("   │ R. Revenir au menu principal");
        System.out.println("   │ Q. Quitter le jeu");
        System.out.print("\n   Entrez A, M, C, R ou Q : ");
    }

    private void playerMenu(List<Person> players) {
        String answer;
        do {
            displayPlayerMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "A":
//                    displayPlayer(players.getLast());
                    displayAllPlayers(players);
                    break;
                case "M":
                    players.remove(players.getLast());
                    players.add(createPlayer());
                    ;
                    break;
                case "C":
                    players.add(createPlayer());
                    break;
                case "R":
                    System.out.println("   Retour au menu principal :\n");
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    System.out.println(Colors.colored(Colors.ANSI_RED, "   Ce choix n'est pas autorisé\n"));
            }
        } while (!answer.equals("R"));
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
                    Msg.red("Ce choix n'est pas autorisé\n");
            }
        } while (!answer.equals("R"));
    }


    private void displayMainMenu() {
        System.out.println("=========================");
//        System.out.println("      MENU PRINCIPAL     ");
        Msg.blue("\u001b[1m" + "      MENU PRINCIPAL     " + "\u001b[0m");
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println("=========================");
        System.out.println("C. Créer des joueurs");
        System.out.println("A. Afficher les joueurs déjà créés");
        System.out.println("J. Jouer !");
        System.out.println("Q. Quitter le jeu");
        System.out.print("\nEntrez C, A, D ou Q : ");
    }

    /**
     * Display a menu to create a list of players, and start the game
     *
     * @return List of <Person>, after the user chooses "J" (Jouer)
     */
    public List<Person> createPlayers() {
        String answer;
        List<Person> players = new ArrayList<Person>();

        do {
            displayMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "C": // Create player
                    // Add player (interactively)
                    players.add(createPlayer());
                    // Call player menu to display or modify created player
                    playerMenu(players);
                    break;
                case "A": // Display players
                    displayAllPlayers(players);
                    break;
                case "J": // Start Game
                    if (players.isEmpty()) {
                        // Créer d'abord
                        Msg.red("Vous ne pouvez pas jouer tant que " +
                                "vous n'avez pas créé de joueur !");
                        break;
                    }
                    return players;
                case "Q":
                    quit();
                default:
                    Msg.red("Ce choix n'est pas autorisé\n");
            }
        } while (true);

//        return null;
    }

    public void printBox(String text) {
        Msg.printBox(text);
    }

    public void displayWinner(Person player) {
        System.out.println();
        Msg.rainbow(player.getName() + " a gagné !");
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
