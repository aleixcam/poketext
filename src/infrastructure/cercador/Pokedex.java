package infrastructure.cercador;

import application.pokedex.GetPokedexes.GetPokedexesService;
import infrastructure.persistence.SQLite.PokedexRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.service.ReaderService;
import infrastructure.presentation.transformer.matrix.PokedexAssemblerMatrix;

import java.util.Arrays;

public class Pokedex {

    public static String[] cercarPokedex() {
        String[] pokedex;
        String s;
        int selected;

        GetPokedexesService service = new GetPokedexesService(new PokedexRepositorySQLite(), new PokedexAssemblerMatrix());
        String[][] pokedexes = service.execute();

        String[] options = new String[pokedexes.length];
        for (int i = 0; i < pokedexes.length; i++) {
            options[i] = pokedexes[i][0];
        }

        MatrixPrinter.print(pokedexes);
        System.out.printf("%n");

        do {

            s = ReaderService.read();
            selected = Arrays.asList(options).indexOf(s);

            if (selected >= 0) {
                pokedex = pokedexes[selected];
                System.out.printf("Has seleccionat la pokèdex %S!%n", pokedex[1]);
            } else {
                System.out.println("No existeix la pokèdex seleccionada");
            }
        } while (selected < 0);

        return pokedexes[selected];
    }
}
