package DD.board;

import DD.tools.OffensiveTool;

public class Arm extends OffensiveTool implements Square {

    public Arm(int attackLevel, String name) {
        super(attackLevel, name);
    }

    public Arm() {
        super();
    }

    @Override
    public void openSquare() {
        System.out.println("Arm");
    }
}
