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

    public String[][] execute(GetPokemonsRequest request) {
        PokemonCriteria criteria = new PokemonCriteria();
        criteria.setPokedexId(request.getPokedexId());
        criteria.setName(request.getName());
        criteria.setType(request.getType());

        PokemonsCollection pokemons = repository.findByCriteria(criteria);
        return assembler.assemble(pokemons);
    }
}
