package pokedex.infrastructure.controller;

import common.application.Command.Menu;
import pokemon.infrastructure.controller.PokemonController;
import pokedex.application.Command.SelectPokedexCommand;
import pokemon.application.Command.RemoveFilterCommand;
import pokemon.application.Command.SetNameFilterCommand;
import pokemon.application.Command.SetTypeFilterCommand;
import common.infrastructure.classes.cercador.*;
import common.infrastructure.service.ReaderService;

final public class PokedexController {

    public void pokemons() {
        String[] s;

        PokemonController receiver = new PokemonController();

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", SelectPokedexCommand.of(receiver), "Cambiar Pokèdex");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");
        menu.recursiveExecute();
    }

    public void moves() {
        Moves.viewMoves();
    }

    public void items() {
        Objectes.cercarObjectes();
    }

    public void abilities() {
        Habilitats.cercarHabilitats();
    }
}
