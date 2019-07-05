package pokedex.infrastructure.controller;

import common.application.Command.Menu;
import pokemon.infrastructure.controller.PokemonController;
import pokedex.application.Command.SelectPokedexCommand;
import pokemon.application.Command.RemoveFilterCommand;
import pokemon.application.Command.SetNameFilterCommand;
import pokemon.application.Command.SetTypeFilterCommand;
import common.infrastructure.classes.cercador.*;

final public class PokedexController {

    public void pokemons() {
        PokemonController receiver = new PokemonController();
        receiver.selectPokedex();

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", SelectPokedexCommand.of(receiver), "Cambiar Pokèdex");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");

        menu.execute();
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
