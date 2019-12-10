package indexer.pokedex.domain;

import java.util.ArrayList;

public class PokedexCollection {

    private ArrayList<Pokedex> pokedexes = new ArrayList<>();

    public void add(Pokedex pokedex) {
        pokedexes.add(pokedex);
    }

    public ArrayList<Pokedex> getPokedexes() {
        return pokedexes;
    }
}
