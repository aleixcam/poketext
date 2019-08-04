package indexer.pokedex.application.GetPokedexes;

import indexer.pokedex.application.PokedexTransformer;
import indexer.pokedex.domain.PokedexRepository;
import indexer.pokedex.domain.PokedexesCollection;

public class GetPokedexesUseCase {

    private PokedexRepository repository;
    private PokedexTransformer assembler;

    public GetPokedexesUseCase(PokedexRepository repository, PokedexTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute() {
        PokedexesCollection pokedexes = this.repository.findAll();
        return this.assembler.assemble(pokedexes);
    }
}
