package shared.infrastructure.controller;

import indexer.ability.application.Command.SearchAbilitiesCommand;
import shared.domain.Command.Menu;
import indexer.pokedex.infrastructure.controller.PokedexController;
import indexer.item.application.Command.SearchItemsCommand;
import indexer.move.application.Command.SearchMovesCommand;
import indexer.pokemon.application.Command.SearchPokemonsCommand;
import shared.infrastructure.service.ReaderService;
import showndown.player.legacy.Jugadors;
import teambuilder.team.infrastructure.controller.TeamController;

final public class AppController {

    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teambuilder() {
        boolean sortir = false;
        String sel;
        do {

            System.out.printf("%nPOKETEXT: CONSTRUCTOR D'EQUIPS%n");
            System.out.println("C. Crear un nou equip");
            System.out.println("M. Modificar un equip");
            System.out.println("E. Eliminar un equip");
            System.out.println("P. Eliminar un Pokèmon");
            System.out.println("Q. Sortir al menú principal");
            sel = ReaderService.read();

            // Seleccions del menú principal
            if (sel.equalsIgnoreCase("c")) {
                TeamController.createTeamAction();
            } else if (sel.equalsIgnoreCase("m")) {
                TeamController.importTeamAction();
            } else if (sel.equalsIgnoreCase("e")) {
                TeamController.removeTeamAction();
            } else if (sel.equalsIgnoreCase("p")) {
                TeamController.removePokemonAction();
            } else if (sel.equalsIgnoreCase("q")) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }

    public void pokedex() {
        PokedexController receiver = new PokedexController();

        Menu menu = new Menu("POKETEXT: POKÈDEX");
        menu.register("P", SearchPokemonsCommand.of(receiver), "Cerca Pokèmons");
        menu.register("M", SearchMovesCommand.of(receiver), "Cerca Moviments");
        menu.register("O", SearchItemsCommand.of(receiver), "Cerca Objectes");
        menu.register("A", SearchAbilitiesCommand.of(receiver), "Cerca Habilitats");

        menu.execute();
    }
}
