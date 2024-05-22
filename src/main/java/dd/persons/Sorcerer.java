package main.java.dd.persons;

import java.util.Random;

public class Sorcerer extends Enemy {

    public Sorcerer(String name) {
        super(name);
        this.life = 15;
        this.strength = 4 + (int) new Random().nextInt(2);
    }

    @Override
    public String getTypeString() {
        return "sorcier \uD83E\uDDD9\uD83C\uDFFE";
    }

}
