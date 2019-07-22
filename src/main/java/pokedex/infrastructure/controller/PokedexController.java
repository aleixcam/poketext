package pokedex.infrastructure.controller;

import common.domain.Command.Menu;
import move.infrastructure.controller.MoveController;
import pokemon.infrastructure.controller.PokemonController;
import pokedex.application.Command.SelectPokedexCommand;
import common.application.search.Command.RemoveFilterCommand;
import common.application.search.Command.SetNameFilterCommand;
import common.application.search.Command.SetTypeFilterCommand;
import common.infrastructure.classes.cercador.*;

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

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");

        menu.execute();
        MoveController.viewMoves();
    }

    public void items() {
        Objectes.cercarObjectes();
    }

    public void abilities() {
        Habilitats.cercarHabilitats();
    }
}
