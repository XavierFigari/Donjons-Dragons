package dd.persons;

public class Dragon extends Enemy {

    public Dragon(String name) {
        super(name);
        this.life = 17;
        this.strength = 4;
    }

     @Override
    public String getTypeString() {
        return "dragon \uD83D\uDC09";
    }

    @Override
    public String getType() {
        return "dragon";
    }

}
