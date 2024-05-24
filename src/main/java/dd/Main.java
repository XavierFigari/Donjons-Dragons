package dd;

import dd.db.DatabaseDD;
import dd.game.Game;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        new DatabaseDD();

        do {
            Game game = new Game();
            game.play();
        } while (true);
    }

}
