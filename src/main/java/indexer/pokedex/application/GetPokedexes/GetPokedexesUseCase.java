package indexer.pokedex.application.GetPokedexes;

import indexer.pokedex.application.PokedexTransformer;
import indexer.pokedex.domain.PokedexRepository;
import indexer.pokedex.domain.PokedexesCollection;

public class GetPokedexesUseCase<T> {

    private PokedexRepository repository;
    private PokedexTransformer<T> transformer;

    public GetPokedexesUseCase(PokedexRepository repository, PokedexTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute() {
        PokedexesCollection pokedexes = this.repository.findAll();
        return this.transformer.transform(pokedexes);
    }
}
