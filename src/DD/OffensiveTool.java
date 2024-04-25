package DD;

enum Arms {
    SWORD,
    CLUB
}

enum Spells {
    FIREBALL,
    LIGHTNING
}

enum OffensiveToolType {
    ARM,
    SPELL
}

public class OffensiveTool {
    private final OffensiveToolType toolType;
    private final int attackLevel;
    private final String name;

    public OffensiveTool(OffensiveToolType toolType, int attackLevel, String name) {
        this.toolType = toolType;
        this.attackLevel = attackLevel;
        this.name = name;
    }

    // Getters
    public OffensiveToolType getToolType() {
        return toolType;
    }
    public int getAttackLevel() {
        return attackLevel;
    }
    public String getName() {
        return name;
    }

    // No setters, as attributes are final : only the constructor can change them
}
