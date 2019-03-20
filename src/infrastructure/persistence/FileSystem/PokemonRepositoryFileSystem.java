package infrastructure.persistence.FileSystem;

import java.util.List;

public class PokemonRepositoryFileSystem extends FileSystemRepository {

    // final private String DIRECTORY = "pokemon";

    public String[][] findByName(String name) {
        return buildPokemon(read(name));
    }

    private String[][] buildPokemon(List<String> data) {
        String[] arr = new String[data.size()];
        return importarCSV(data.toArray(arr), ",");
    }

    public void save(String[][] pokemon, String name) {
        write(exportarCSV(pokemon, ","), name);
    }
}
