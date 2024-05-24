package dd.tools;

public class Lightning extends OffensiveTool {
    public Lightning() {
        super();
        this.attackLevel = 2;
    }

    @Override
    public String getOffensiveToolDatabaseName() {
        return "lightning";
    }

    @Override
    public String toString() {
        return "un éclair ⚡️";
    }
}
