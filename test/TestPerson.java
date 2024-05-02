import DD.persons.Person;
import DD.persons.PlayerType;
import DD.persons.Warrior;

public class TestPerson {

    public static void main(String[] args) {
        testResetWarrior();
    }

    private static void testResetWarrior() {
        String name = "toto";
        PlayerType type = PlayerType.WARRIOR;
//        Person p = new Person(name, type);
        Person p = new Warrior(name);

        p.setPosition(99);
        p.setLife(98);
        p.setForce(97);
        System.out.println(p.getName().equals(name));
        System.out.println(p.getPosition() == 99);
        System.out.println(p.getLife() == 98);
        System.out.println(p.getForce() == 97);

        p.reset();
        System.out.println(p.getName().equals(name));
        System.out.println(p.getPosition() == 1);
        System.out.println(p.getLife() == 10);
        System.out.println(p.getForce() == 10);
    }
}
