package main.java.dd.board.tools;

import main.java.dd.UserInterface;
import main.java.dd.persons.Person;
import main.java.dd.tools.Fireball;

import java.util.List;

public class SquareFireball extends SquareTool {

    public SquareFireball(UserInterface ui, List<Person> allowedPersons) {
        super(ui, allowedPersons);
        this.tool = new Fireball();
    }

    @Override
    public String toString() {
        return "Case boule de feu";
    }

}
