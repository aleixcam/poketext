package infrastructure.presentation.controller;

import application.command.Menu;
import infrastructure.combat.Jugadors;
import infrastructure.service.ReaderService;
import infrastructure.teambuilder.Equips;

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

        Menu menu = new Menu("POKETEXT: POKEDEX");
        menu.register("P", receiver::pokemons, "Cerca Pokèmons");
        menu.register("M", receiver::moves, "Cerca Moviments");
        menu.register("O", receiver::objects, "Cerca Objectes");
        menu.register("A", receiver::abilities, "Cerca Habilitats");

        do {
            menu.print();
            selection = ReaderService.read().toUpperCase();

            menu.execute(selection);
        } while (!selection.equals(menu.EXIT));
    }
}
