package shared.infrastructure.controller;

import indexer.ability.application.Command.SearchAbilitiesCommand;
import shared.domain.Command.Menu;
import indexer.pokedex.infrastructure.controller.PokedexController;
import indexer.item.application.Command.SearchItemsCommand;
import indexer.move.application.Command.SearchMovesCommand;
import indexer.pokemon.application.Command.SearchPokemonsCommand;
import showndown.player.legacy.Jugadors;
import teambuilder.team.legacy.Equips;

final public class AppController {

    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teambuilder() {
        Equips.construirEquip();
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
