package indexer.pokemon.application;

import indexer.pokemon.domain.PokemonCollection;

public interface PokemonTransformer<T> {

    T transform(PokemonCollection collection);
}
