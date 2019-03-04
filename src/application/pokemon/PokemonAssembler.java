package application.pokemon;

import domain.pokemon.PokemonsCollection;

public interface PokemonAssembler {

    String[][] assemble(PokemonsCollection moves);
}
