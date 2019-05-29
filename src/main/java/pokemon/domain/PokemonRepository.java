package pokemon.domain;

public interface PokemonRepository {

    PokemonsCollection findByCriteria(PokemonCriteria criteria);
    BaseStats findStatsByPokemonId(int pokemon_id);
}
