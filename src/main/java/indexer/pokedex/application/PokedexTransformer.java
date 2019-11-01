package indexer.pokedex.application;

import indexer.pokedex.domain.PokedexesCollection;

public interface PokedexTransformer<T> {

    T transform(PokedexesCollection pokedexes);
}
