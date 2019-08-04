package indexer.pokemon.infrastructure.persistence.FileSystem;

import shared.domain.CSVService;
import shared.infrastructure.persistence.FileSystemRepositoryImpl;

import java.util.List;

final public class PokemonRepositoryImpl extends FileSystemRepositoryImpl<String[][]> {

    public PokemonRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/pokemon";
    }

    @Override
    protected String[][] build(List<String> csv) {
        return csvService.fromCSV(csv.toArray(new String[0]));
    }

    @Override
    protected String[] getCSV(String[][] pokemon) {
        return csvService.toCSV(pokemon);
    }
}
