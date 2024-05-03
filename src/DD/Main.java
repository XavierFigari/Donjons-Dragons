package DD;

import DD.game.Game;

public class Main {
    public static void main(String[] args) {
        do {

            Game game = new Game();
            game.play();
        } while (true);
    }

}
