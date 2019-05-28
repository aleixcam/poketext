package infrastructure.presentation.controller;

import application.command.Menu;
import application.pokedex.Command.SelectPokedexCommand;
import application.pokemon.Command.RemoveFilterCommand;
import application.pokemon.Command.SetNameFilterCommand;
import application.pokemon.Command.SetTypeFilterCommand;
import infrastructure.poketext.cercador.*;
import infrastructure.service.ReaderService;

final public class PokedexController {

    public void pokemons() {
        String[] s;

        PokemonController receiver = new PokemonController();

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", SelectPokedexCommand.of(receiver), "Cambiar Pokèdex");
        menu.register("N", SetNameFilterCommand.of(receiver), "Filtrar per nom");
        menu.register("T", SetTypeFilterCommand.of(receiver), "Filtrar per tipus");
        menu.register("E", RemoveFilterCommand.of(receiver), "Eliminar filtre");

        do {
            menu.print();
            s = ReaderService.toArray();

            menu.execute(s);
        } while (!menu.isExit(s));
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
