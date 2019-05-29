package poketext.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Connector {

    public static Connection connection;

    public static String getDatabase() {
        return "jdbc:sqlite:" + Objects.requireNonNull(
            Connector.class.getClassLoader().getResource("data/sqlite/pokedex.sqlite")
        ).getPath();
    }

    static void connectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(getDatabase());
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    static void tancar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
