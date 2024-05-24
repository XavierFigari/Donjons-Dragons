package dd.persons;

import dd.tools.Fireball;
import dd.tools.Philtre;

import java.util.Random;

public class Wizard extends Hero {

    public Wizard(String name) {
        super(name);
        // The life of a warrior is between 3 and 6
        this.life = 10 + (int) new Random().nextInt(4);
        this.strength = 9;
        this.offensiveTool = new Fireball();
        this.defensiveTool = new Philtre();
    }

    @Override
    public void reset() {
        super.reset();
        this.life = 6;
        this.strength = 15;
        this.offensiveTool = new Fireball();
        this.defensiveTool = new Philtre();
    }

    @Override
    public String getTypeString() {
        return "Magicien \uD83E\uDDD9";
    }

    public String getType() {
        return "Wizard";
    }

    @Override
    public void setLife(int life) throws PersonIsDeadException {
        super.setLife(life);
        if (life <= 0) throw new PersonIsDeadException(this);
    }

}
