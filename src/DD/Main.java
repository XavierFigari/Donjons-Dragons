package DD;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        List<Person> players;

        menu.printBox("DONJONS ET DRAGONS" );

        while (true) {
            players = menu.createPlayers();
            Game game = new Game(menu); // on passe le menu en paramètre pour
                                        // pouvoir l'appeler depuis Game
            game.play(players);
            // Si je suis ici, c'est que le jeu est terminé
            menu.endOfGameMenu();
        }
    }

}
