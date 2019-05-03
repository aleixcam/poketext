package application.pokedex;

import infrastructure.cercador.Habilitats;
import infrastructure.cercador.Moves;
import infrastructure.cercador.Objectes;
import infrastructure.cercador.Pokemons;

public class PokedexReceiver {

    public void pokemons() {
        Pokemons.cercarPokemons();
    }

    public void moves() {
        Moves.viewMoves();
    }

    public void objects() {
        Objectes.cercarObjectes();
    }

    public void abilities() {
        Habilitats.cercarHabilitats();
    }
}
