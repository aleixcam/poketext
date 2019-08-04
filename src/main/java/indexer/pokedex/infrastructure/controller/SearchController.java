package indexer.pokedex.infrastructure.controller;

import indexer.pokedex.application.GetPokedexes.GetPokedexesUseCase;
import indexer.pokedex.infrastructure.injector.PokedexApplicationInjector;
import shared.infrastructure.printer.MatrixPrinter;
import shared.infrastructure.service.ReaderService;

import java.util.Arrays;

final public class SearchController {

    public static String[] search() {
        String[] pokedex;
        String s;
        int selected;

        String[][] pokedexes = getGetPokedexesUseCase().execute();

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

    private static GetPokedexesUseCase getGetPokedexesUseCase() {
        return PokedexApplicationInjector.injectGetPokedexesUseCase();
    }
}
