package pokemon.application.GetPokemons;

import pokemon.application.PokemonTransformer;
import pokemon.domain.PokemonCriteria;
import pokemon.domain.PokemonRepository;
import pokemon.domain.PokemonsCollection;

public class GetPokemonsUseCase {

    private PokemonRepository repository;
    private PokemonTransformer assembler;

    public GetPokemonsUseCase(PokemonRepository repository, PokemonTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(int pokedex_id, String name, String type) {
        PokemonCriteria criteria = new PokemonCriteria();
        criteria.setPokedexId(pokedex_id);
        criteria.setName(name);
        criteria.setType(type);

        PokemonsCollection pokemons = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(pokemons);
    }
}
