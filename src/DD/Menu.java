package DD;

import java.util.Scanner;

public class Menu {

    public void mainMenu(Scanner sc) {
        String answer;
        System.out.println("Que voulez-vous faire ?");
        System.out.println("C. Créer un personnage");
        System.out.println("Q. Quitter le jeu");
        System.out.print("Entrez C ou Q : ");

        answer = sc.nextLine();

        if (answer.equals("C")) {
            createPlayer(sc);
        } else if (answer.equals("Q")) {
            System.out.println("Bye bye...");
            System.exit(0);
        }
    }

    private String getPlayerType(Scanner sc) {

    }

    private void createPlayer(Scanner sc) {
        String playerType = "";
        String name = "";

        System.out.println();
        System.out.println("Création d'un personnage");
        System.out.println("------------------------");

        System.out.print("- Guerrier (G) ou Magicien (M) ? ");
        while (!playerType.equals("G") && !playerType.equals("M")) {
            playerType = sc.nextLine();
            if (!playerType.equals("G") && !playerType.equals("M")) {
                System.out.print("Entrez G ou M : ");;
            }
        } ;

        System.out.print("- Quel est son nom ? ");
        name = sc.nextLine();

        ===================================================== HERE

        System.exit(0);

    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        menu.mainMenu(sc);
    }
}

//final class MyScanner {
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