package DD.tools;


enum PotionType {
    STDPOTION,
    BIGPOTION
}

enum DefensiveToolType {
    SHIELD,
    PHILTRE
}

public abstract class DefensiveTool {

    private final int defenseLevel;
    private final String name;

    public DefensiveTool(int defenseLevel, String name) {
        this.defenseLevel = defenseLevel;
        this.name = name;
    }

    // Getters
    public int getDefenseLevel() {
        return defenseLevel;
    }
    public String getName() {
        return name;
    }

    // No setters, as attributes are final : only the constructor can change them

}
