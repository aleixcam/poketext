package cercador;

import application.pokedex.GetPokedexesService;
import infrastructure.persistence.sqlite.PokedexRepositorySQLite;
import infrastructure.transformer.matrix.PokedexAssemblerMatrix;
import utils.Comuna;

import java.io.IOException;
import java.util.Arrays;

public class Pokedex {

    static String[] cercarPokedex() throws IOException {
        String[] pokedex;
        String s;
        int index;

        GetPokedexesService service = new GetPokedexesService(new PokedexRepositorySQLite(), new PokedexAssemblerMatrix());
        String[][] pokedexes = service.execute();

        String[] ids = new String[pokedexes.length];
        for (int i = 0; i < pokedexes.length; i++) {
            ids[i] = pokedexes[i][0];
        }

        System.out.printf("%n%2s | %-16s| %s%n", pokedexes[0][0], pokedexes[0][1], pokedexes[0][2]);
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 1; i < pokedexes.length; i++) {
            System.out.printf("%2s | %-16s| %s%n", pokedexes[i][0], pokedexes[i][1], pokedexes[i][2]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");

        do {

            s = Comuna.obtenirText();
            index = Arrays.asList(ids).indexOf(s);

            if (index >= 0) {
                pokedex = pokedexes[index];
                System.out.printf("Has seleccionat la pokèdex %S!%n", pokedex[1]);
            } else {
                System.out.println("No existeix la pokèdex seleccionada");
            }
        } while (index < 0);

        return pokedexes[index];
    }
}
