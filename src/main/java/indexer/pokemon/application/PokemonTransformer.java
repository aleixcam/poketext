package indexer.pokemon.application;

import indexer.pokemon.domain.PokemonsCollection;

public interface PokemonTransformer<E> {

    E transform(PokemonsCollection collection);
}
