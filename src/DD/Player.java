package DD;

enum PlayerType {
    WARRIOR,
    MAGICIAN
}

public class Player {
    // Attributes
    private final String name;
    private final PlayerType type;
    private int life;
    private int force;

    // Constructors
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
        if (type == PlayerType.WARRIOR) {
            this.life = 10;
        } else if (type == PlayerType.MAGICIAN) {
            this.life = 6;
        }
    }
    public Player(String name) {
        this.name = name;
        this.type = null;
    }
    public Player() {
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

    // Setters
    public void setLife(int life) {
        this.life = life;
    }
    public void setForce(int force) {
        this.force = force;
    }
    
}
