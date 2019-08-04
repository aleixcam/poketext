package indexer.pokedex.application;

import indexer.pokedex.domain.PokedexesCollection;

public interface PokedexTransformer {

    String[][] assemble(PokedexesCollection pokedexes);
}
