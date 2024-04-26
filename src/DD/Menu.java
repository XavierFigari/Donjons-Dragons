package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private String getPlayerName(Scanner sc) {
        String textInput = "";
        System.out.print("- Nom ? ");
        return sc.nextLine();
    }

    private PlayerType getPlayerType(Scanner sc) {
        String textInput = "";
        System.out.print("- Guerrier (G) ou Magicien (M) ? ");
        while (!textInput.equals("G") && !textInput.equals("M")) {
            textInput = sc.nextLine();
            if (!textInput.equals("G") && !textInput.equals("M")) {
                System.out.print("Entrez G ou M : ");;
            }
        } ;
        return textInput.equals("G") ? PlayerType.WARRIOR : PlayerType.MAGICIAN;
    }

    private Person createPlayer(Scanner sc) {
        System.out.println();
        System.out.println("Création d'un personnage");
        System.out.println("------------------------");
        return new Person(getPlayerName(sc), getPlayerType(sc));
    }

    private void quit() {
        System.out.println("Bye bye...");
        System.exit(0);
    }

    private void modifyPlayer(Person person, Scanner sc) {
        System.out.println(person);
        System.out.println(" ");
        person.setName(getPlayerName(sc));
        person.setType(getPlayerType(sc));
    }

    private void displayPlayer(Person person) {
        System.out.println("\n" + person);
    }

    private void displayPlayerMenu() {
        System.out.println(" ");
        System.out.println("   Que voulez-vous faire maintenant ?\n");
        System.out.println("   │ A. Afficher le personnage créé");
        System.out.println("   │ M. Modifier le personnage");
        System.out.println("   │ R. Revenir au menu principal");
        System.out.println("   │ Q. Quitter le jeu");
        System.out.print(  "\n   Entrez A, M, R ou Q : ");
    }

    private void playerMenu(Scanner sc, List<Person> people) {
        String answer;
        do {
            displayPlayerMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "A": displayPlayer(people.getLast()); break;
                case "M": modifyPlayer(people.getLast(), sc); break;
                case "R": System.out.println("   Retour au menu principal :\n"); break;
                case "Q": quit(); break;
                default: System.out.print("Entrez A, M, R ou Q : ");
            }
        } while (! answer.equals("R"));
    }

    private void displayMainMenu() {
        System.out.println("=========================");
        System.out.println("      MENU PRINCIPAL     ");
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println("=========================");
        System.out.println("C. Créer un personnage");
        System.out.println("A. Afficher les personnages déjà créés");
        System.out.println("Q. Quitter le jeu");
        System.out.print("\nEntrez C, A ou Q : ");
    }

    public void mainMenu(Scanner sc) {
//        Menu menu = new Menu();
        Game game = new Game();
        String answer;
        List<Person> people = new ArrayList<Person>();

        do {
            displayMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "C": // Create player
                    // Add player (interactively)
                    people.add(createPlayer(sc));
                    // Call player menu to display or modify created player
                    playerMenu(sc, people);
                    break;
                case "A": // Display players
                    System.out.println(people); break;
                case "G": // Start Game
                    game.start(people); break;
                case "Q": quit(); break;
                default:
                    System.out.println("Ce choix n'est pas autorisé");
            }
        } while (! answer.equals("Q"));
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