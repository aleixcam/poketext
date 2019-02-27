package cercador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.pokemon.GetPokemonsService;
import infrastructure.persistence.sqlite.PokemonRepositorySQLite;
import infrastructure.transformer.matrix.MatrixAssembler;
import infrastructure.transformer.matrix.PokemonAssemblerMatrix;
import poketext.Connector;
import utils.Comuna;

public class Pokemons {

    // Consultar l'ID de la pokèdex seleccionada
    private static String consultarIDPokedex(String id, boolean sel) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select name from pokedex_prose "
                + "where pokedex_id = '" + id + "'\n"
                + "and local_language_id = 9");
        result = select.executeQuery();
        if (sel) {
            if (result.next()) {
                System.out.printf("Has seleccionat la pokèdex %S!%n", result.getString("name"));
                res = id;
            } else {
                System.out.println("No existeix la pokèdex seleccionada");
            }
        } else if (result.next()) {
            res = result.getString("name");
        }
        return res;
    }

    private static void consultarPokedex() throws SQLException {
        PreparedStatement st = Connector.connect.prepareStatement("select pokedex_id, name, description\n"
                + "from pokedex_prose\n"
                + "where local_language_id = 9");
        ResultSet result = st.executeQuery();
        System.out.printf("%n%2s | %-16s| %s%n", "ID", "Nom", "Descripció");
        System.out.println("-----------------------------------------------------------------------------------------------");
        while (result.next()) {
            System.out.printf("%2s | %-16s| %s%n", result.getString("pokedex_id"), result.getString("name"), result.getString("description"));
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static String escollirPokedex() throws SQLException, IOException {
        String pokedex = "";
        consultarPokedex();
        do {
            pokedex = consultarIDPokedex(Comuna.obtenirText(), true);
        } while (pokedex.equals(""));
        return pokedex;
    }

    // Escollir un pokèmon per a l'equip
    public static void cercarPokemons() throws IOException {
        String pokedex, filter_type = "", filter_name = "", s[];
        boolean sortir = false;

        try {
            pokedex = escollirPokedex();
            do {

                GetPokemonsService service = new GetPokemonsService(new PokemonRepositorySQLite(), new PokemonAssemblerMatrix());
                String[][] pokemons = service.execute(Integer.parseInt(pokedex), filter_name, filter_type);

                // Mostrar per pantalla els pokèmons
                System.out.printf("%nPokèdex: %s%n", consultarIDPokedex(pokedex, false));
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                MatrixAssembler.printQuery(pokemons);
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                System.out.printf("Pokèdex: %s%n%n", consultarIDPokedex(pokedex, false));

                // Opcions del menú
                System.out.printf("%nCERCADOR: POKÈDEX%n");
                System.out.println("P. Cambiar Pokèdex");
                System.out.println("N. Filtrar per nom");
                System.out.println("T. Filtrar per tipus");
                System.out.println("E. Eliminar filtre");
                System.out.println("Q. Sortir");
                s = Comuna.obtenirText().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("p")) && (s.length == 1)) {
                    pokedex = escollirPokedex();
                } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("t")) && (s.length == 2)) {
                    filter_type = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (s[1].equalsIgnoreCase("n")) {
                        filter_name = "";
                    } else if (s[1].equalsIgnoreCase("t")) {
                        filter_type = "";
                    }
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } while (!sortir);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
