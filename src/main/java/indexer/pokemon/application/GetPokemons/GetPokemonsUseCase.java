package indexer.pokemon.application.GetPokemons;

import indexer.pokemon.application.PokemonTransformer;
import indexer.pokemon.domain.PokemonCriteria;
import indexer.pokemon.domain.PokemonRepository;
import indexer.pokemon.domain.PokemonsCollection;

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
