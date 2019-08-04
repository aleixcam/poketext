package teambuilder.team.domain;

import indexer.pokemon.domain.Pokemon;

public class Team {

    private Pokemon[] pokemons;

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }
}
