package cercador;

import application.pokedex.GetPokedexesService;
import infrastructure.persistence.sqlite.PokedexRepositorySQLite;
import infrastructure.transformer.matrix.PokedexAssemblerMatrix;
import poketext.Connector;
import utils.Comuna;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pokedex {

    private static String consultarIDPokedex(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select name from pokedex_prose "
                + "where pokedex_id = '" + id + "'\n"
                + "and local_language_id = 9");
        result = select.executeQuery();

        if (result.next()) {
            System.out.printf("Has seleccionat la pokèdex %S!%n", result.getString("name"));
            res = id;
        } else {
            System.out.println("No existeix la pokèdex seleccionada");
        }

        return res;
    }

    private static void consultarPokedex() {
        GetPokedexesService service = new GetPokedexesService(new PokedexRepositorySQLite(), new PokedexAssemblerMatrix());
        String[][] pokedexes = service.execute();

        System.out.printf("%n%2s | %-16s| %s%n", pokedexes[0][0], pokedexes[0][1], pokedexes[0][2]);
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 1; i < pokedexes.length; i++) {
            System.out.printf("%2s | %-16s| %s%n", pokedexes[i][0], pokedexes[i][1], pokedexes[i][2]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public static String escollirPokedex() throws SQLException, IOException {
        String pokedex = "";
        consultarPokedex();
        do {
            pokedex = consultarIDPokedex(Comuna.obtenirText());
        } while (pokedex.equals(""));
        return pokedex;
    }
}
