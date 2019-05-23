package infrastructure.presentation.controller;

import application.ability.Command.SearchAbilitiesCommand;
import application.command.Menu;
import application.item.Command.SearchItemsCommand;
import application.move.Command.SearchMovesCommand;
import application.pokemon.Command.SearchPokemonsCommand;
import infrastructure.poketext.combat.Jugadors;
import infrastructure.service.ReaderService;
import infrastructure.poketext.teambuilder.Equips;

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
