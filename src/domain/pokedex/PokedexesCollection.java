package domain.pokedex;

import java.util.ArrayList;

public class PokedexesCollection {

    private ArrayList<Pokedex> items = new ArrayList<>();

    public void add(Pokedex pokedex) {
        items.add(pokedex);
    }

    public ArrayList<Pokedex> pokedexes() {
        return items;
    }
}
