package dd;

import dd.game.Game;

public class Main {
    public static void main(String[] args) {
        do {
            Game game = new Game();
            game.play();
        } while (true);
    }

}
