package indexer.pokemon.application;

import indexer.pokemon.domain.PokemonsCollection;

public interface PokemonTransformer {

    String[][] assemble(PokemonsCollection moves);
}
