package infrastructure.persistence.FileSystem;

import infrastructure.service.ConvertCSVService;

import java.util.List;

public class PokemonRepositoryFileSystem extends FileSystemRepository {

    // final private String DIRECTORY = "pokemon";

    public String[][] get(String path) {
        return buildPokemon(read(path));
    }

    public void save(String[][] pokemon, String path) {
        write(ConvertCSVService.toCSV(pokemon), path);
    }

    public void delete(String path) {
        erase(path);
    }

    private String[][] buildPokemon(List<String> data) {
        String[] arr = new String[data.size()];
        return ConvertCSVService.fromCSV(data.toArray(arr));
    }
}
