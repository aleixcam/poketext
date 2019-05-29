package pokemon.application;

import pokemon.domain.PokemonsCollection;

public interface PokemonTransformer {

    String[][] assemble(PokemonsCollection moves);
}
