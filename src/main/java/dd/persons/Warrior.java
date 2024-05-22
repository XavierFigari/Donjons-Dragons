package main.java.dd.persons;

import main.java.dd.tools.Axe;
import main.java.dd.tools.Shield;
import main.java.dd.tools.Sword;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        Random random = new Random();
        // The life of a warrior is between 5 and 10
        this.life = 15 + random.nextInt(6);
        this.strength = 10;
        switch (random.nextInt(2)) {
            case 0:
                this.offensiveTool = new Sword();
                break;
            case 1:
                this.offensiveTool = new Axe();
                break;
        }
        this.defensiveTool = new Shield();
    }


    @Override
    public void reset() {
        super.reset();
        this.life = 10;
        this.strength = 10;
        this.offensiveTool = new Sword();
        this.defensiveTool = new Shield();
    }

    @Override
    public String getTypeString() {
        return "Guerrier \uD83E\uDD77";
    }

//    @Override
//    public void setLife(int life) throws PersonIsDeadException {
//        super.setLife(life);
//        if (life <= 0) throw new PersonIsDeadException(this);
//    }


}