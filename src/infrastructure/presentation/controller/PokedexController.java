package infrastructure.presentation.controller;

import application.command.Command;
import application.command.Menu;
import application.pokemon.Service.RemoveFilterCommand;
import application.pokemon.Service.SearchPokemonsService;
import infrastructure.poketext.cercador.*;
import infrastructure.service.ReaderService;

final public class PokedexController {

    private void select() {
        Pokedex.cercarPokedex();
    }

    void pokemons() {
        String[] s;

        SearchPokemonsService receiver = new SearchPokemonsService();
        Command removeFilters = new RemoveFilterCommand(receiver, "n");

        Menu menu = new Menu("POKÈDEX: POKÈMONS");
        menu.register("P", this::select, "Cambiar Pokèdex");
        menu.register("N", receiver::setNameFilter, "Filtrar per nom");
        menu.register("T", receiver::setTypeFilter, "Filtrar per tipus");
        menu.register("E", removeFilters, "Eliminar filtre");

        do {
            menu.print();
            s = ReaderService.read().split(" ");

            menu.execute(s[0]);
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
