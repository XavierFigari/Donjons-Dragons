package main.java.dd.persons;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Person {
    private List<Hero> heroes = new ArrayList<Hero>();

    public Hero(String name) {
        super(name);
    }

    @Override
    public String getTypeString() {
        return "Hero";
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }
}
