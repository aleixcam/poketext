package teambuilder.pokemon.domain;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public final class TeamPokemonCollection {

    public static final int MAX_SIZE = 6;

    private ArrayList<TeamPokemon> pokemons = new ArrayList<>();

    public void add(TeamPokemon pokemon) throws LimitExceededException {
        guardFromTooManyPokemons();
        pokemons.add(pokemon);
    }

    public ArrayList<TeamPokemon> pokemons() {
        return pokemons;
    }

    private void guardFromTooManyPokemons() throws LimitExceededException {
        if (pokemons.size() > MAX_SIZE) {
            throw new LimitExceededException();
        }
    }
}
