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
        Msg.blue("\n*** TOUR DE JEU " + n + " ***\n");
    }

    public void displayPlayerTurn(int playerIndex, int diceValue, int newPosition) {
        Msg.green("Joueur " + playerIndex);
        Msg.white("  Dé = " + diceValue);
        Msg.white("  Nelle position = " + newPosition);
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
                ;
            }
        }
        ;
        return textInput.equals("G") ? PlayerType.WARRIOR : PlayerType.WIZARD;
    }

    private Person createPlayer() {
        System.out.println();
        System.out.println("Création d'un personnage");
        System.out.println("------------------------");
        return new Person(getPlayerName(), getPlayerType());
    }

    public void quit() {
        System.out.println("Bye bye...");
        System.exit(0);
    }

    private void modifyPlayer(Person player) {
        System.out.println(player);
        System.out.println(" ");
        PlayerType playerType = getPlayerType();
        player.setName(getPlayerName());
        player.setType(playerType);
        switch (playerType) {
            case WARRIOR:
                player.setLife(10);
                player.setForce(10);
                break;
            case WIZARD:
                player.setLife(6);
                player.setForce(15);
        }
    }

    private void displayPlayer(Person player) {
        System.out.println("\n" + player);
    }

    private void displayAllPlayers(List<Person> players) {
        if (players.isEmpty()) {
            Msg.red("\nAucun joueur n'a été créé");
        } else {
            System.out.println("\nListe des joueurs :\n");
            for (Person player : players) {
                System.out.println(player);
            }
        }
    }

    private void displayPlayerMenu() {
        System.out.println(" ");
        System.out.println("   Que voulez-vous faire maintenant ?\n");
        System.out.println("   │ A. Afficher le personnage créé");
        System.out.println("   │ M. Modifier le personnage");
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
                    displayPlayer(players.getLast());
                    break;
                case "M":
                    modifyPlayer(players.getLast());
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
        Msg.blue("      MENU PRINCIPAL     ");
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println("=========================");
        System.out.println("C. Créer un joueur");
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
                    if (players.size() == 0) {
                        // Créer d'abord = C
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

}

// essai de Singleton :

// final class MyScanner {
//    Scanner sc;
//    private static final MyScanner instance = new MyScanner();
//    private MyScanner(){
//        // init the scanner
//        sc = new Scanner(System.in);
//    }
//    //Get the only object available
//    public static MyScanner getInstance(){
//        return instance;
//    }
//}