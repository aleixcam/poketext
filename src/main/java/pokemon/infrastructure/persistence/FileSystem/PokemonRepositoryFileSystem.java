package pokemon.infrastructure.persistence.FileSystem;

import common.infrastructure.persistence.FileSystemRepository;
import common.infrastructure.service.ConvertCSVService;

import java.util.List;

final public class PokemonRepositoryFileSystem extends FileSystemRepository {

    final public String DIRECTORY = "data/memory/pokemon";

    public String[][] get(String name) {
        return assemblePokemon(read(getPath(name)));
    }

    public void save(String[][] pokemon, String name) {
        write(ConvertCSVService.toCSV(pokemon), getPath(name));
    }

    protected String getPath(String file) {
        return String.format("%s/%s", DIRECTORY, file);
    }

    private String[][] assemblePokemon(List<String> data) {
        String[] arr = new String[data.size()];
        return ConvertCSVService.fromCSV(data.toArray(arr));
    }
}
