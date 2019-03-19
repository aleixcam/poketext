package cercador;

import application.pokedex.GetPokedexes.GetPokedexesService;
import infrastructure.persistence.SQLite.PokedexRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.presentation.transformer.matrix.PokedexAssemblerMatrix;

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

        MatrixPrinter.print(pokedexes);
        System.out.printf("%n");

        do {

            s = StreamReader.read();
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
