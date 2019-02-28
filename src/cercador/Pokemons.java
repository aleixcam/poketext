package cercador;

import java.io.IOException;
import java.sql.SQLException;

import application.pokemon.GetPokemonsService;
import infrastructure.persistence.sqlite.PokemonRepositorySQLite;
import infrastructure.transformer.matrix.MatrixAssembler;
import infrastructure.transformer.matrix.PokemonAssemblerMatrix;
import utils.Comuna;

public class Pokemons {

    // Escollir un pokèmon per a l'equip
    public static void cercarPokemons() throws IOException {
        String pokedex, filter_type = "", filter_name = "", s[];
        boolean sortir = false;

        try {
            pokedex = Pokedex.escollirPokedex();
            do {

                GetPokemonsService service = new GetPokemonsService(new PokemonRepositorySQLite(), new PokemonAssemblerMatrix());
                String[][] pokemons = service.execute(Integer.parseInt(pokedex), filter_name, filter_type);

                // Mostrar per pantalla els pokèmons
                System.out.printf("%nPokèdex: %s%n", Pokedex.consultarIDPokedex(pokedex, false));
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                MatrixAssembler.printQuery(pokemons);
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                System.out.printf("Pokèdex: %s%n%n", Pokedex.consultarIDPokedex(pokedex, false));

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
                    pokedex = Pokedex.escollirPokedex();
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
