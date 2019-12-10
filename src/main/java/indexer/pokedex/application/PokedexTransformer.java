package indexer.pokedex.application;

import indexer.pokedex.domain.PokedexCollection;

public interface PokedexTransformer<T> {

    T transform(PokedexCollection pokedexes);
}
