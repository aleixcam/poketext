package poketext.infrastructure.controller;

import ability.application.Command.SearchAbilitiesCommand;
import common.application.Command.Menu;
import pokedex.infrastructure.controller.PokedexController;
import item.application.Command.SearchItemsCommand;
import move.application.Command.SearchMovesCommand;
import pokemon.application.Command.SearchPokemonsCommand;
import common.infrastructure.classes.combat.Jugadors;
import common.infrastructure.service.ReaderService;
import common.infrastructure.classes.teambuilder.Equips;

final public class AppController {

    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teambuilder() {
        Equips.construirEquip();
    }

    public void pokedex() {
        String selection;

        PokedexController receiver = new PokedexController();

        Menu menu = new Menu("POKETEXT: POKÈDEX");
        menu.register("P", SearchPokemonsCommand.of(receiver), "Cerca Pokèmons");
        menu.register("M", SearchMovesCommand.of(receiver), "Cerca Moviments");
        menu.register("O", SearchItemsCommand.of(receiver), "Cerca Objectes");
        menu.register("A", SearchAbilitiesCommand.of(receiver), "Cerca Habilitats");

        do {
            menu.print();
            selection = ReaderService.read();

            menu.execute(selection);
        } while (!menu.isExit(selection));
    }
}
