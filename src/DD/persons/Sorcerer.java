package DD.persons;

public class Sorcerer extends Enemy {

    public Sorcerer(String name) {
        super(name);
        this.life = 9;
        this.strength = 2;
    }

    @Override
    public String getTypeString() {
        return "sorcier \uD83E\uDDD9\uD83C\uDFFE";
    }

}
