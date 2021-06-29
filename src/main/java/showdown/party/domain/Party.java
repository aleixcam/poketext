package showdown.party.domain;

import showdown.pokemon.domain.Pokemon;

public final class Party {

    private final Pokemon[] pokemons;

    public Party(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon getPokemon(int index) {
        return this.pokemons[index];
    }
}
