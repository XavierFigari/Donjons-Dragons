package main.java.dd;

import main.java.dd.game.Game;

public class Main {
    public static void main(String[] args) {
        do {
            Game game = new Game();
            game.play();
        } while (true);
    }

}
