package DD.persons;

import DD.tools.Fireball;
import DD.tools.Philtre;

public class Wizard extends Person {

    public Wizard(String name) {
        super(name);
        this.life = 6;
        this.strength = 15;
        this.offensiveTool = new Fireball();
        this.defensiveTool = new Philtre();
    }

    @Override
    public PlayerType getType() {
        return PlayerType.WIZARD;
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

}
