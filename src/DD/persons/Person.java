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
    protected OffensiveTool offensiveTool; // arm (warrior) or spell (wizard)
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

    @Override
    public String toString() {
        return
//                "    " + Colors.colored(Colors.ANSI_GREEN, "Personnage") + "\n" +
                        "         Nom    = " + Colors.colstr(Colors.ANSI_GREEN, getName()) + '\n' +
                        "         Type   = " + getTypeString() + '\n' +
                        "         ❤️     = " + getLife() + '\n' +
                        "         \uD83D\uDCAA     = " + getStrength() + '\n' ;
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
    public int getPosition() { return position; }

    // Abstract methods
    public abstract String getTypeString();

    // Setters
    // --------------------------------------------------------------------------
    public void setName(String name) { this.name = name; }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setPosition(int position) { this.position = position; }

    public void setLife(int life) throws PersonIsDeadException {
        this.life = life;
        if (life<0) throw new PersonIsDeadException(this);
    }


}
