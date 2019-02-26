package domain.pokemon;

public interface PokemonRepository {

    // PokemonsCollection findByCriteria(String filter_name, String filter_type, String pokedex);
    int[] findStatsByPokemonId(int pokemon_id);
}
