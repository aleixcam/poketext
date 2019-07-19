package pokemon.infrastructure.persistence.FileSystem;

import common.domain.service.CSVService;
import common.infrastructure.persistence.FileSystemRepositoryImpl;

import java.util.List;

final public class PokemonRepositoryImpl extends FileSystemRepositoryImpl {

    public PokemonRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/pokemon";
    }

    public String[][] get(String name) {
        return assemblePokemon(read(getPath(name)));
    }

    public void save(String[][] pokemon, String name) {
        write(csvService.toCSV(pokemon), getPath(name));
    }

    protected String getPath(String file) {
        return String.format("%s/%s", directory, file);
    }

    private String[][] assemblePokemon(List<String> data) {
        String[] arr = new String[data.size()];
        return csvService.fromCSV(data.toArray(arr));
    }
}
