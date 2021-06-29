package indexer.pokemon.domain;

import indexer.pokemon.domain.ValueObject.BaseStats;

public interface PokemonRepository {

    PokemonCollection findByCriteria(PokemonCriteria criteria);
    BaseStats findStatsByPokemonId(int pokemon_id);
}
