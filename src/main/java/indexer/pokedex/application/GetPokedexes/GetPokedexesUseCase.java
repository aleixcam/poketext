package indexer.pokedex.application.GetPokedexes;

import indexer.pokedex.application.PokedexTransformer;
import indexer.pokedex.domain.PokedexRepository;
import indexer.pokedex.domain.PokedexCollection;

public class GetPokedexesUseCase<T> {

    private PokedexRepository repository;
    private PokedexTransformer<T> transformer;

    public GetPokedexesUseCase(PokedexRepository repository, PokedexTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute() {
        PokedexCollection pokedexes = this.repository.findAll();
        return this.transformer.transform(pokedexes);
    }
}
