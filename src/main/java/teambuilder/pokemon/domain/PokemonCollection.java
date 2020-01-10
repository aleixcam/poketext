package teambuilder.pokemon.domain;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public final class PokemonCollection {

    public static final int MAX_SIZE = 6;

    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public void add(Pokemon pokemon) throws LimitExceededException {
        guardFromTooManyPokemons();
        pokemons.add(pokemon);
    }

    public ArrayList<Pokemon> pokemons() {
        return pokemons;
    }

    private void guardFromTooManyPokemons() throws LimitExceededException {
        if (pokemons.size() > MAX_SIZE) {
            throw new LimitExceededException();
        }
    }
}
