package teambuilder.pokemon.infrastructure.persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import teambuilder.pokemon.domain.Service.PokemonRepository;


final public class FileSystemPokemonRepository implements PokemonRepository {

    private final CSVFileSystemManager fileSystemManager;

    public FileSystemPokemonRepository(CSVFileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/pokemon");
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
