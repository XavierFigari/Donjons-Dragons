package DD.persons;

public class Dragon extends Enemy {

    public Dragon(String name) {
        super(name);
        this.life = 15;
        this.strength = 4;
    }

     @Override
    public String getTypeString() {
        return "dragon \uD83D\uDC09";
    }

}
