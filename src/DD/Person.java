package DD;

enum PlayerType {
    WARRIOR,
    MAGICIAN
}

public class Person {
    // Attributes
    private String name;
    private PlayerType type;
    private int life;
    private int force;
    private DefensiveTool defensiveTool;
    private OffensiveTool offensiveTool;
    private int position;

    // Constructors

    public Person(String name, PlayerType type) {
        this.name = name;
        this.type = type;
        if (type == PlayerType.WARRIOR) {
            this.life = 10;
            this.force = 10;
            this.offensiveTool = new OffensiveTool(OffensiveToolType.ARM, 5, "Epée");
            this.defensiveTool = new DefensiveTool(DefensiveToolType.SHIELD, 5, "Bouclier");
        } else if (type == PlayerType.MAGICIAN) {
            this.life = 6;
            this.force = 15;
            this.offensiveTool = new OffensiveTool(OffensiveToolType.SPELL, 5, "");
            this.defensiveTool = new DefensiveTool(DefensiveToolType.SHIELD, 5, "Bouclier");
        }
        this.position = 1;
    }

    public Person(String name) {
        this.name = name;
        this.type = null;
    }

    public Person() {
        this.type = null;
        this.name = "";
    }

    // Getters
    public String getName() {
        return name;
    }
    public PlayerType getType() {
        return type;
    }
    public int getLife() {
        return life;
    }
    public int getForce() {
        return force;
    }
    public int getPosition() { return position; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setType(PlayerType type) { this.type = type; }
    public void setLife(int life) {
        this.life = life;
    }
    public void setForce(int force) {
        this.force = force;
    }
    public void setPosition(int position) { this.position = position; }

    @Override
    public String toString() {
        return
                "    Player :\n" +
                "       >  name  = " + getName() + '\n' +
                "       >  type  = " + getType() + '\n' +
                "       >  life  = " + getLife() + '\n' +
                "       >  force = " + getForce() + '\n' ;
    }


}
