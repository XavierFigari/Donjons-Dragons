package DD.persons;

import DD.tools.Sword;
import DD.tools.Shield;

public class Warrior extends Person {

    public Warrior(String name) {
        super(name);
        this.life = 10;
        this.strength = 10;
        this.offensiveTool = new Sword();
        this.defensiveTool = new Shield();
    }

    @Override
    public PlayerType getType() {
        return PlayerType.WARRIOR;
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

}