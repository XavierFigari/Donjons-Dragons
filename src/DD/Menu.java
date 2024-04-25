package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private void displayDragon() {
        System.out.println(" ");
    }
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

    private Player createPlayer(Scanner sc) {
        System.out.println();
        System.out.println("Création d'un personnage");
        System.out.println("------------------------");
        return new Player(getPlayerName(sc), getPlayerType(sc));
    }

    private String getAnswerFromMainMenu(Scanner sc) {
        String answer;
        System.out.println("=========================");
        System.out.println("      MENU PRINCIPAL     ");
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println("=========================");
        System.out.println("C. Créer un personnage");
        System.out.println("A. Afficher les personnages déjà créés");
        System.out.println("Q. Quitter le jeu");
        System.out.print("\nEntrez C, A ou Q : ");
        answer = sc.nextLine();
        return answer;
    }

    private String getAnswerFromPlayerMenu(Scanner sc) {
        String answer;
        System.out.println(" ");
        System.out.println("   Que voulez-vous faire maintenant ?\n");
        System.out.println("   │ A. Afficher le personnage créé");
        System.out.println("   │ M. Modifier le personnage");
        System.out.println("   │ R. Revenir au menu principal");
        System.out.println("   │ Q. Quitter le jeu");
        System.out.print(  "\n   Entrez A, M, R ou Q : ");
        answer = sc.nextLine();
        return answer;
    }

    private void displayPlayer(Player player) {
        System.out.println("\n" + player);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        String answer;
        List<Player> players = new ArrayList<Player>();

        menu.displayDragon();

        do {
            answer = menu.getAnswerFromMainMenu(sc);
            switch (answer) {
                case "C":
                    players.add(menu.createPlayer(sc));
                    do {
                        answer = menu.getAnswerFromPlayerMenu(sc);
                        switch (answer) {
                            case "A": menu.displayPlayer(players.getLast()); break;
                            case "M": menu.modifyPlayer(players.getLast(), sc); break;
                            case "R": System.out.println("   Retour au menu principal :\n"); break;
                            case "Q": menu.quit(); break;
                            default: System.out.print("Entrez A, M, R ou Q : ");
                        }
                    } while (! answer.equals("R"));
                    break;
                case "A":
                    System.out.println(players);; break;
                case "Q": menu.quit(); break;
            }
        } while (! answer.equals("Q"));
    }

    private void quit() {
        System.out.println("Bye bye...");
        System.exit(0);
    }

    private void modifyPlayer(Player player, Scanner sc) {
        System.out.println(player);
        System.out.println(" ");
        player.setName(getPlayerName(sc));
        player.setType(getPlayerType(sc));
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