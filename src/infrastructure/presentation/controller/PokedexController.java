package infrastructure.presentation.controller;

import application.command.Command;
import application.command.Menu;
import application.pokedex.Command.SelectPokedexCommand;
import application.pokemon.Command.RemoveFilterCommand;
import application.pokemon.Command.SetNameFilterCommand;
import application.pokemon.Command.SetTypeFilterCommand;
import application.pokemon.Service.SearchPokemonsService;
import infrastructure.poketext.cercador.*;
import infrastructure.service.ReaderService;

final public class PokedexController {


    void pokemons() {
        String[] s;

        SearchPokemonsService receiver = new SearchPokemonsService();
        Command selectPokedex = new SelectPokedexCommand(receiver);
        Command setNameFilter = new SetNameFilterCommand(receiver);
        Command setTypeFilter = new SetTypeFilterCommand(receiver);
        Command removeFilters = new RemoveFilterCommand(receiver);

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", selectPokedex, "Cambiar Pokèdex");
        menu.register("N", setNameFilter, "Filtrar per nom");
        menu.register("T", setTypeFilter, "Filtrar per tipus");
        menu.register("E", removeFilters, "Eliminar filtre");

        do {
            menu.print();
            s = ReaderService.read().split(" ");

            menu.execute(s);
        } while (!s[0].equals(menu.EXIT));
    }

    public void moves() {
        Moves.viewMoves();
    }

    void objects() {
        Objectes.cercarObjectes();
    }

    void abilities() {
        Habilitats.cercarHabilitats();
    }
}
