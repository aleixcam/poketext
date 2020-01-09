package indexer.pokemon.domain;

import shared.pokemon.domain.Entity.BaseStats;

public interface PokemonRepository {

    PokemonCollection findByCriteria(PokemonCriteria criteria);
    BaseStats findStatsByPokemonId(int pokemon_id);
}
