package pokedex.application;

import pokedex.domain.PokedexesCollection;

public interface PokedexTransformer {

    String[][] assemble(PokedexesCollection pokedexes);
}
