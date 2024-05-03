package DD.tools;

enum WeaponType {
    SWORD,
    CLUB
}
enum SpellType {
    FIREBALL,
    LIGHTNING
}
enum OffensiveToolType {
    ARM,
    SPELL
}
public abstract class OffensiveTool {

    private int attackLevel;
    private String name;

    public OffensiveTool() {

    }

    public OffensiveTool(int attackLevel, String name) {
        this.attackLevel = attackLevel;
        this.name = name;
    }

    // Getters
    public int getAttackLevel() {
        return attackLevel;
    }
    public String getName() {
        return name;
    }

    // No setters, as attributes are final : only the constructor can change them
}
