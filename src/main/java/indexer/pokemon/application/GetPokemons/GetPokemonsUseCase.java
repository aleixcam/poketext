package indexer.pokemon.application.GetPokemons;

import indexer.pokemon.application.PokemonTransformer;
import indexer.pokemon.domain.PokemonCriteria;
import indexer.pokemon.domain.PokemonRepository;

public class GetPokemonsUseCase {

    private PokemonRepository repository;
    private PokemonTransformer<String[][]> transformer;

    public GetPokemonsUseCase(PokemonRepository repository, PokemonTransformer<String[][]> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public String[][] execute(GetPokemonsRequest request) {
        PokemonCriteria criteria = new PokemonCriteria();
        criteria.setPokedexId(request.getPokedexId());
        criteria.setName(request.getName());
        criteria.setType(request.getType());

        return transformer.transform(repository.findByCriteria(criteria));
    }
}
