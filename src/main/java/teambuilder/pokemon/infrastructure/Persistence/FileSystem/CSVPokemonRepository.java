package teambuilder.pokemon.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import teambuilder.pokemon.domain.Service.PokemonRepository;


final public class CSVPokemonRepository implements PokemonRepository {

    private final CSVFileSystemManager fileSystemManager;

    public CSVPokemonRepository(CSVFileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/pokemon");
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
