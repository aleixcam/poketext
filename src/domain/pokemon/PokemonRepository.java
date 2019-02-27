package domain.pokemon;

public interface PokemonRepository {

    PokemonsCollection findByCriteria(PokemonCriteria criteria);
    int[] findStatsByPokemonId(int pokemon_id);
}
