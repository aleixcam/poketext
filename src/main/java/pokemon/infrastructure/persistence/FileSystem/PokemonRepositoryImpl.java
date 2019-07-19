package pokemon.infrastructure.persistence.FileSystem;

import common.domain.CSVService;
import common.infrastructure.persistence.FileSystemRepositoryImpl;
import pokemon.domain.Pokemon;

import java.util.List;

final public class PokemonRepositoryImpl extends FileSystemRepositoryImpl<Pokemon> {

    public PokemonRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/pokemon";
    }

    @Override
    protected Pokemon build(List<String> data) {
        return new Pokemon();
    }

    @Override
    protected String[] deconstruct(Pokemon entity) {
        return new String[0];
    }
}
