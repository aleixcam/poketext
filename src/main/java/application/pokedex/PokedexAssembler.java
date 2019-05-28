package application.pokedex;

import domain.pokedex.PokedexesCollection;

public interface PokedexAssembler {

    String[][] assemble(PokedexesCollection pokedexes);
}
