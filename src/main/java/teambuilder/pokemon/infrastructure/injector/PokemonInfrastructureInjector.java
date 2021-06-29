package teambuilder.pokemon.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.pokemon.infrastructure.persistence.FileSystem.FileSystemPokemonRepository;

public class PokemonInfrastructureInjector {

    public static FileSystemPokemonRepository fileSystemPokemonRepository() {
        return new FileSystemPokemonRepository(
            SharedInfrastructureInjector.csvFileSystemManager()
        );
    }
}
