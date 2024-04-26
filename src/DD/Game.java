package DD;

import java.util.List;
import java.util.Random;

public class Game {

    public void start(List<Person> people) {
        int n;
        System.out.println("Le jeu démarre !");
        for (Person person : people) {
            n = throwDice();
            person.setPosition(n);
        }
    }

    private int throwDice() {
        Random rand = new Random();
        // return random int between 1 and 6
        return rand.nextInt(7) + 1;
    }
}
