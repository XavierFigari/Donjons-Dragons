package dd.game;

import java.util.Random;

public class NormalDice implements Dice {
    @Override
    public int throwDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
