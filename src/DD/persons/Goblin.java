package DD.persons;

public class Goblin extends Enemy {

    public Goblin(String name) {
        super(name);
        this.life = 6;
        this.strength = 1;
    }

     @Override
    public String getTypeString() {
        return "gobelin \uD83D\uDC79";
    }

}
