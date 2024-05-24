package dd.db;

import dd.persons.*;
import dd.tools.Axe;
import dd.tools.Fireball;
import dd.tools.Lightning;
import dd.tools.Sword;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDD {
    private static Connection con = DatabaseDD.getConnection();

    public DatabaseDD() throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "toto");
        System.out.println("DatabaseDD created");
    }
    public static Connection getConnection()
    {
        return con;
    }


    // =============================================================
    // Méthode : createPerson
    // =============================================================
    public static void createPerson(Person person) throws SQLException {
        String query = "insert into dd.heroes (name, type, life, strength, weapon) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, person.getName());
        ps.setObject(2, person.getType(), java.sql.Types.OTHER);
        ps.setInt(3, person.getLife());
        ps.setInt(4, person.getStrength());
        ps.setString(5, person.getOffensiveTool().getOffensiveToolDatabaseName()); // sword, axe, fireball, lightning
        ps.executeUpdate();
    }

    // =============================================================
    // Méthode : updatePerson
    // =============================================================
    public static void updatePerson(Person person) throws SQLException {
        String query = "update dd.heroes set life = ?, strength = ?, weapon = ? where name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, person.getLife());
        ps.setInt(2, person.getStrength());
        ps.setString(3, person.getOffensiveTool().getOffensiveToolDatabaseName());
        ps.setString(4, person.getName());
        ps.executeUpdate();
    }

    // =============================================================
    // Méthode : getPersons
    // =============================================================
    public static List<Person> getPersons() throws SQLException {

        Person person = null;

        String query = "select * from dd.heroes";
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        List<Person> ls = new ArrayList<>();

        while (rs.next()) {
            String type = rs.getString("type");
            String name = rs.getString("name");
            try {
                // reflection : instanciation dynamique
                Class<? extends Person> clazz = (Class<? extends Person>) Class.forName("dd.persons." + type);
                person = clazz.getDeclaredConstructor(String.class).newInstance(name);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
//            switch (type) {
//                case "warrior":
//                    person = new Warrior(name);
//                    break;
//                case "wizard":
//                    person = new Wizard(name);
//                    break;
//            }
            assert person != null;
            try {
                person.setLife(rs.getInt("life"));
            } catch (PersonIsDeadException e) {
                System.out.println("Warning : life is 0 in database");
            }
            person.setStrength(rs.getInt("strength"));
            switch (rs.getString("weapon")) {
                case "sword":
                    person.setOffensiveTool(new Sword());
                    break;
                case "axe":
                    person.setOffensiveTool(new Axe());
                    break;
                case "fireball":
                    person.setOffensiveTool(new Fireball());
                    break;
                case "lightning":
                    person.setOffensiveTool(new Lightning());
            }
            ls.add(person);
        }
        return ls;

    }

}
