package dd.tools;

public abstract class OffensiveTool {

    protected int attackLevel;

    public OffensiveTool() {
    }
    public abstract String  getOffensiveToolDatabaseName() ;

    // Getters
    public int getAttackLevel() {
        return attackLevel;
    }
}
