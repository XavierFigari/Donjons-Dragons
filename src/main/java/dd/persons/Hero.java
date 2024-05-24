package dd.persons;

public class Hero extends Person {

    public Hero(String name) {
        super(name);
    }

    public Hero() {
    }

    @Override
    public String getTypeString() {
        return "Hero";
    }

    @Override
    public String getType() {
        return "hero";
    }

}
