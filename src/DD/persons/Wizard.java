package DD.persons;

import DD.tools.Philtre;
import DD.tools.Spell;

public class Wizard extends Person {

    public Wizard(String name) {
        super(name);
        this.life = 6;
        this.force = 15;
        this.offensiveTool = new Spell(5, "Sort de ouf");
        this.defensiveTool = new Philtre(5, "Philtre de ouf");
    }

    @Override
    public PlayerType getType() {
        return PlayerType.WIZARD;
    }

    @Override
    public void reset() {
        super.reset();
        this.life = 6;
        this.force = 15;
        this.offensiveTool = new Spell(5, "Sort de ouf");
        this.defensiveTool = new Philtre(5, "Philtre de ouf");
    }

    @Override
    public String getTypeString() {
        return "\uD83E\uDDD9 Magicien";
    }

}
