package main.java.dd.persons;

public class PersonIsDeadException extends Exception {
    public Person person;
    public PersonIsDeadException(Person person) {
        this.person = person;
    }
}
