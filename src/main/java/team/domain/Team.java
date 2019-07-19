package team.domain;

import pokemon.domain.Pokemon;

public class Team {

    private Pokemon[] pokemons;

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }
}
