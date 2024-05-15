package DD.persons;

import DD.Colors;
import DD.tools.OffensiveTool;
import DD.tools.DefensiveTool;

public abstract class Person {

    // Attributes
    // --------------------------------------------------------------------------
    protected String name;
    // available to children (protected) :
    protected int life;
    protected int strength;

    protected DefensiveTool defensiveTool; // shield (warrior) or philtre (wizard)
    protected OffensiveTool offensiveTool; // sword, hammer (warrior) or fireball, lightning (wizard)

    protected int position;

    // Constructors
    // --------------------------------------------------------------------------
    public Person(String name) {
        this.name = name;
        this.position = 0;
    }
    // Methods
    // --------------------------------------------------------------------------

    abstract public PlayerType getType();

    public void reset() {
        this.position = 0;
    }

    //    public abstract String pickOffensiveTool(OffensiveTool offensiveTool);

    public String pickTool(OffensiveTool newOffensiveTool) {
        String message;
        if (this.offensiveTool.getClass() == newOffensiveTool.getClass()) {
            message = "Tu as déjà cette arme : " + this.offensiveTool;
        } else if (this.offensiveTool.getAttackLevel() > newOffensiveTool.getAttackLevel()) {
            message = "Tu as déjà une meilleure arme : " + this.offensiveTool;
        } else {
            message = "Tu as déjà " + this.offensiveTool + " mais cette arme est meilleure. Prends-là !\n";
            this.setOffensiveTool(newOffensiveTool);
            message += "Avec cette arme, ta force sera augmentée de "
                    + newOffensiveTool.getAttackLevel() +
                    " points, tu auras donc une force totale de "
                    + this.getTotalStrength() + " points.";
        }
        return message;
    }

    @Override
    public String toString() {
        return
                "         Nom    = " + Colors.colstr(Colors.ANSI_GREEN, getName()) + '\n' +
                        "         Type   = " + getTypeString() + '\n' +
                        "         ❤️     = " + getLife() + '\n' +
                        "         \uD83D\uDCAA     = " + getStrength() + '\n';
    }

    // Getters
    // --------------------------------------------------------------------------

    public String getName() {
        return name;
    }
    public int getLife() {
        return life;
    }
    public int getStrength() {
        return strength;
    }
    public int getTotalStrength() {
        return strength + offensiveTool.getAttackLevel();
    }
    public int getPosition() {
        return position;
    }
    public OffensiveTool getOffensiveTool() {
        return offensiveTool;
    }
    public DefensiveTool getDefensiveTool() {
        return defensiveTool;
    }

    // Abstract methods

    public abstract String getTypeString();
    // Setters
    // --------------------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setLife(int life) throws PersonIsDeadException {
        this.life = life;
        if (life < 0) throw new PersonIsDeadException(this);
    }
        public void setDefensiveTool(DefensiveTool defensiveTool) {
        this.defensiveTool = defensiveTool;
    }
    public void setOffensiveTool(OffensiveTool offensiveTool) {
        this.offensiveTool = offensiveTool;
    }



}
