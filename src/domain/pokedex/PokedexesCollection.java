package domain.pokedex;

import java.util.ArrayList;

public class PokedexesCollection {

    private ArrayList<Pokedex> pokedexes = new ArrayList<>();

    public void add(Pokedex pokedex) {
        pokedexes.add(pokedex);
    }

    public ArrayList<Pokedex> getPokedexes() {
        return pokedexes;
    }
}
