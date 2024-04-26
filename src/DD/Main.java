package DD;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        List<Person> players;

        while (true) {
            players = menu.createPlayers();
            Game game = new Game(menu); // on passe le menu en paramètre pour pouvoir l'appeller depuis Game
            game.play(players);

            // Si je suis ici, c'est que le jeu est terminé
            menu.endOfGameMenu();
            players = menu.createPlayers();
        }
//
//        Menu menu = new Menu();
//        Game game = new Game(menu);
//        while (!game.isFinished()) {
//            game.play();
//        }
//        menu.quit();
    }
}
