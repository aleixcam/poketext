package showndown.pokemon.legacy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shared.legacy.Connector;
import showndown.type.domain.Type;
import showndown.type.infrastructure.injector.TypeInfrastructureInjector;
import showndown.type.infrastructure.persistence.SQLite.TypeRepositoryImpl;

// Clase de efectivitat
public class Danys {

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

    private static int danyRebut(String target, String damage) {
        return typeRepository().getDamageFactor(new Type(target), new Type(damage));
    }

    private static TypeRepositoryImpl typeRepository() {
        return TypeInfrastructureInjector.injectTypeRepository();
    }
}
