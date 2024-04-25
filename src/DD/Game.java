package DD;

import java.util.List;
import java.util.Random;

public class Game {

    public void start(List<Player> players) {
        System.out.println("Le jeu démarre !");
        for (Player player : players) {
            n = throwDice()
            player.setPosition(throwDice());
        }
    }

    private int throwDice() {
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(7) + 1;
    }
}
