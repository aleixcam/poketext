package application.pokedex;

import domain.pokedex.*;

public class GetPokedexesService {

    private PokedexRepository repository;
    private PokedexAssembler assembler;

    public GetPokedexesService(PokedexRepository repository, PokedexAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute() {

        PokedexesCollection pokedexes = this.repository.findAll();
        return this.assembler.assemble(pokedexes);
    }
}
