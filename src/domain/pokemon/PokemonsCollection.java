package domain.pokemon;

import domain.pokemon.Pokemon;

import java.util.ArrayList;

public class PokemonsCollection {

    private ArrayList<Pokemon> items = new ArrayList<>();

    public void add(Pokemon pokemon) {
        items.add(pokemon);
    }

    public ArrayList<Pokemon> pokemons() {
        return items;
    }
}
