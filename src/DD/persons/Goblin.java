package DD.persons;

import java.util.Random;

public class Goblin extends Enemy {

    public Goblin(String name) {
        super(name);
        this.life = 6;
        this.strength = 4 + (int) new Random().nextInt(2);
    }

     @Override
    public String getTypeString() {
        return "gobelin \uD83D\uDC79";
    }

}
