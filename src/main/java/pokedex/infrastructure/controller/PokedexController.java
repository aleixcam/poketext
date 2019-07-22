package pokedex.infrastructure.controller;

import ability.application.GetAbilities.GetAbilitiesUseCase;
import ability.infrastructure.injector.AbilityApplicationInjector;
import common.domain.Command.Menu;
import common.infrastructure.printer.MatrixPrinter;
import common.infrastructure.service.ReaderService;
import item.application.GetItems.GetItemsUseCase;
import item.infrastructure.injector.ItemApplicationInjector;
import move.infrastructure.controller.MoveController;
import pokemon.infrastructure.controller.PokemonController;
import pokedex.application.Command.SelectPokedexCommand;
import common.application.search.Command.RemoveFilterCommand;
import common.application.search.Command.SetNameFilterCommand;
import common.application.search.Command.SetTypeFilterCommand;

final public class PokedexController {

    public void pokemons() {
        PokemonController receiver = new PokemonController();

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", SelectPokedexCommand.of(receiver), "Cambiar Pokèdex");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");

        menu.execute();
    }

    public void moves() {
        MoveController receiver = new MoveController();

        Menu menu = new Menu("POKÈDEX: MOVIMENTS");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");

        menu.execute();
    }

    public void items() {
        String filter_name = "";
        String[] s;
        boolean sortir = false;

        do {

            GetItemsUseCase service = ItemApplicationInjector.injectGetItemsUseCase();
            String[][] items = service.execute(filter_name);

            // Mostrar per pantalla els objectes
            System.out.printf("Nom: %s%n", filter_name);
            MatrixPrinter.print(items);
            System.out.printf("Nom: %s%n", filter_name);

            // Opcions del menú
            System.out.printf("%nCERCADOR: ITEMS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = ReaderService.read().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                filter_name = s[1];
            } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 1)) {
                filter_name = "";
            } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }

    public void abilities() {
        String filter_name = "";
        String[] s;
        boolean sortir = false;

        do {

            GetAbilitiesUseCase service = AbilityApplicationInjector.injectGetAbilitiesUseCase();
            String[][] abilities = service.execute(filter_name);

            // Mostrar per pantalla els moviments
            System.out.printf("Nom: %s%n", filter_name);
            MatrixPrinter.print(abilities);
            System.out.printf("Nom: %s%n", filter_name);

            // Opcions del menú
            System.out.printf("%nCERCADOR: HABILITATS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = ReaderService.read().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                filter_name = s[1];
            } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 1)) {
                filter_name = "";
            } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
