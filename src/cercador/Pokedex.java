package cercador;

import application.pokedex.GetPokedexes.GetPokedexesUseCase;
import infrastructure.persistence.sqlite.PokedexRepositorySQLite;
import infrastructure.transformer.matrix.MatrixAssembler;
import infrastructure.transformer.matrix.PokedexAssemblerMatrix;
import utils.Comuna;

import java.io.IOException;
import java.util.Arrays;

public class Pokedex {

    static String[] cercarPokedex() throws IOException {
        String[] pokedex;
        String s;
        int index;

        GetPokedexesUseCase service = new GetPokedexesUseCase(new PokedexRepositorySQLite(), new PokedexAssemblerMatrix());
        String[][] pokedexes = service.execute();

        String[] ids = new String[pokedexes.length];
        for (int i = 0; i < pokedexes.length; i++) {
            ids[i] = pokedexes[i][0];
        }

        MatrixAssembler.printQuery(pokedexes);
        System.out.printf("%n");

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
