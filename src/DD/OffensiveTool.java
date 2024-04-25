package DD;

//enum ToolType {
//    FIREBALL,
//    STRIKE,
//    SWORD,
//    CLUB
//}

enum OffensiveToolType {
    ARM,
    SPELL
}

public class OffensiveTool {
    private final OffensiveToolType toolType;
    private final int attackLevel;
    private final int name;

    public OffensiveTool(OffensiveToolType toolType, int attackLevel, int name) {
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
    public int getName() {
        return name;
    }

    // No setters, as attributes are final : only the constructor can change them
}
