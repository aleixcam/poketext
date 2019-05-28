package infrastructure.poketext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase que connecta el programa amb la base de dades sqlite
public class Connector {

    // Variables publiques i privades
    private static final String URL = "pokedex.sqlite";
    public static Connection connect;

    // Funció que es connecta a la base de dades
    public static void connectar() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + URL);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Funció per tancar la base de dades
    public static void tancar() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
