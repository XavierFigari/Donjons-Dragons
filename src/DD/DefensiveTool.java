package DD;


enum PotionType {
    POTION,
    BIGPOTION
}

enum DefensiveToolType {
    SHIELD,
    PHILTRE
}

public class DefensiveTool {
    private final DefensiveToolType toolType;
    private final int defenseLevel;
    private final int name;

    public DefensiveTool(DefensiveToolType toolType, int defenseLevel, int name) {
        this.toolType = toolType;
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    // Getters
    public DefensiveToolType getToolType() {
        return toolType;
    }
    public int getDefenseLevel() {
        return defenseLevel;
    }
    public int getName() {
        return name;
    }

    // No setters, as attributes are final : only the constructor can change them

}
