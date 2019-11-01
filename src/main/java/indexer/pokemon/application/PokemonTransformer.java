package indexer.pokemon.application;

import indexer.pokemon.domain.PokemonsCollection;

public interface PokemonTransformer<T> {

    T transform(PokemonsCollection collection);
}
