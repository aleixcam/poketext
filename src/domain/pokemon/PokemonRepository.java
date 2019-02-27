package domain.pokemon;

public interface PokemonRepository {

    PokemonsCollection findByCriteria(PokemonCriteria criteria);
    PokemonStats findStatsByPokemonId(int pokemon_id);
}
