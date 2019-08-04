package showndown.pokemon.legacy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shared.legacy.Connector;

// Clase de efectivitat
public class Danys {

    // Consultar el tipus del moviment
    private static String tipusMoviment(String id) {
        ResultSet result;
        String res = "";
        try {
            PreparedStatement st = Connector.connection.prepareStatement("select type_id from moves where id = " + id);
            result = st.executeQuery();
            while (result.next()) {
                res = result.getString("type_id");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    // Consultar el dany causat per un atac donat el seu tipus i el del pokèmon objectiu
    private static int danyRebut(String target, String damage) {
        ResultSet result;
        int res = 0;
        try {
            PreparedStatement st = Connector.connection.prepareStatement("select damage_factor\n"
                    + "from type_efficacy\n"
                    + "where damage_type_id = " + damage + "\n"
                    + "and target_type_id = " + target);
            result = st.executeQuery();
            while (result.next()) {
                res = result.getInt("damage_factor");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }

    // Calcular els danys que rebrà el pokèmon objectiu tenint en compte els seus 2 tipus
    public static double calcularEfectivitat(String type_one, String type_two, String move) {
        String type_move = tipusMoviment(move);
        int damage_one = danyRebut(type_one, type_move);
        int damage_two = 100;
        if (!type_two.equals("")) {
            damage_two = danyRebut(type_one, type_move);
        }
        return damage_one * damage_two * 0.0001;
    }
}
