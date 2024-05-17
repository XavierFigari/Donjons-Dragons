package DD.persons;

import java.util.Random;

public class Goblin extends Enemy {

    public Goblin(String name) {
        super(name);
        this.life = 20;
        this.strength = 5 + (int) new Random().nextInt(2);
    }

     @Override
    public String getTypeString() {
        return "gobelin \uD83D\uDC79";
    }

}
