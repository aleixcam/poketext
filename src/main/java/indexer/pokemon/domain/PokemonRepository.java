package indexer.pokemon.domain;

public interface PokemonRepository {

    PokemonCollection findByCriteria(PokemonCriteria criteria);
    BaseStats findStatsByPokemonId(int pokemon_id);
}
