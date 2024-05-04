package DD.persons;

import DD.tools.Weapon;
import DD.tools.Shield;

public class Warrior extends Person {

    public Warrior(String name) {
        super(name);
        this.life = 10;
        this.force = 10;
        this.offensiveTool = new Weapon(5, "Epée");
        this.defensiveTool = new Shield(5, "Bouclier");
    }

    @Override
    public PlayerType getType() {
        return PlayerType.WARRIOR;
    }

    @Override
    public void reset() {
        super.reset();
        this.life = 10;
        this.force = 10;
        this.offensiveTool = new Weapon(5, "Epée");
        this.defensiveTool = new Shield(5, "Bouclier");
    }

    @Override
    public String getTypeString() {
        return "\uD83E\uDD77 Guerrier";
    }

}