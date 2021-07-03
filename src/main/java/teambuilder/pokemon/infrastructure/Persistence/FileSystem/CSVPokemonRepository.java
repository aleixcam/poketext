package teambuilder.pokemon.infrastructure.Persistence.FileSystem;

import org.apache.commons.lang3.NotImplementedException;
import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import teambuilder.pokemon.domain.Service.PokemonRepository;

final public class CSVPokemonRepository implements PokemonRepository<String[][]> {

    private final CSVFileSystemManager fileSystemManager;

    public CSVPokemonRepository(CSVFileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/pokemon");
    }

    public String[] list() {
        throw new NotImplementedException("Method CSVPokemonRepository::list not implemented");
    }

    public String[][] get(String ref) {
        throw new NotImplementedException("Method CSVPokemonRepository::get not implemented");
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
