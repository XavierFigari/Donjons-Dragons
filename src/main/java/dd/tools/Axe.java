package dd.tools;

public class Axe extends OffensiveTool {

    public Axe() {
        super();
        this.attackLevel = 3;
    }

    @Override
    public String getOffensiveToolDatabaseName() {
        return "axe";
    }

    @Override
    public String toString() {
        return "une hache \uD83E\uDE93";
    }
}
