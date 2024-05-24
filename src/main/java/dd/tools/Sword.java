package dd.tools;

public class Sword extends OffensiveTool {

    public Sword() {
        super();
        this.attackLevel = 5;
    }

    @Override
    public String getOffensiveToolDatabaseName() {
        return "sword";
    }

    @Override
    public String toString() {
        return "une épée \uD83D\uDDE1";
    }
}
