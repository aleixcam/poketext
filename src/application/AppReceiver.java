package application;

import application.pokedex.PokedexReceiver;
import infrastructure.combat.Jugadors;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.teambuilder.Equips;

public class AppReceiver {

    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teambuilder() {
        Equips.construirEquip();
    }

    public void pokedex() {
        String selection;

        PokedexReceiver receiver = new PokedexReceiver();

        Menu menu = new Menu("POKETEXT: POKEDEX");
        menu.register("P", receiver::pokemons, "Cerca Pokèmons");
        menu.register("M", receiver::moves, "Cerca Moviments");
        menu.register("O", receiver::objects, "Cerca Objectes");
        menu.register("A", receiver::abilities, "Cerca Habilitats");

        do {
            menu.print();
            selection = StreamReader.read().toUpperCase();

            menu.execute(selection);
        } while (!selection.equals(menu.EXIT));
    }
}
